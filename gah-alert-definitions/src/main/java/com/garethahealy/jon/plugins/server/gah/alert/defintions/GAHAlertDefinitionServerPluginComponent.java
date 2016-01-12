/*
 * #%L
 * GarethHealy :: JBoss ON :: Plugins :: GAH Alert Definitions
 * %%
 * Copyright (C) 2013 - 2016 Gareth Healy
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.garethahealy.jon.plugins.server.gah.alert.defintions;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.configuration.Configuration;
import org.rhq.core.domain.configuration.PropertyList;
import org.rhq.core.domain.configuration.PropertyMap;
import org.rhq.core.domain.configuration.PropertySimple;
import org.rhq.core.domain.criteria.AlertDefinitionCriteria;
import org.rhq.core.domain.criteria.ResourceTypeCriteria;
import org.rhq.core.domain.resource.ResourceType;
import org.rhq.enterprise.server.alert.AlertDefinitionManagerLocal;
import org.rhq.enterprise.server.auth.SubjectManagerLocal;
import org.rhq.enterprise.server.plugin.pc.ControlFacet;
import org.rhq.enterprise.server.plugin.pc.ControlResults;
import org.rhq.enterprise.server.plugin.pc.ServerPluginComponent;
import org.rhq.enterprise.server.plugin.pc.ServerPluginContext;
import org.rhq.enterprise.server.resource.ResourceTypeManagerLocal;
import org.rhq.enterprise.server.util.LookupUtil;

public class GAHAlertDefinitionServerPluginComponent implements ServerPluginComponent, ControlFacet {

    private final Log log = LogFactory.getLog(GAHAlertDefinitionServerPluginComponent.class);

    private ServerPluginContext context;

    @Override
    public void initialize(ServerPluginContext context) throws Exception {
        this.context = context;
        log.debug("The plugin has been initialized; " + this);
    }

    @Override
    public void start() {
        boolean injectAtPluginStartup = Boolean.valueOf(context.getPluginConfiguration().getSimpleValue("injectAtPluginStartup", "true"));
        boolean replaceIfExists = Boolean.valueOf(context.getPluginConfiguration().getSimpleValue("replaceIfExists", "false"));
        if (injectAtPluginStartup) {
            injectAllAlertDefs(replaceIfExists);
        }

        log.debug("The plugin has started; " + this);
    }

    @Override
    public void stop() {
        log.debug("The plugin has stopped; " + this);
    }

    @Override
    public void shutdown() {
        log.debug("The plugin has been shut down; " + this);
    }

    @Override
    public ControlResults invoke(String name, Configuration parameters) {
        ControlResults controlResults = new ControlResults();

        try {
            if (name.equals("listInjectedAlertDefinitions")) {
                PropertyList result = new PropertyList("injectedAlertDefinitions");
                for (InjectedTemplate iad : InjectedTemplatesList.INJECTED_TEMPLATES) {
                    PropertyMap map = new PropertyMap("injectedAlertDefinition");
                    map.put(new PropertySimple(InjectedTemplate.FIELD_PLUGIN_NAME, iad.getPluginName()));
                    map.put(new PropertySimple(InjectedTemplate.FIELD_RESOURCE_TYPE_NAME, iad.getResourceTypeName()));
                    map.put(new PropertySimple(InjectedTemplate.FIELD_NAME, iad.getName()));
                    map.put(new PropertySimple(InjectedTemplate.FIELD_DESCRIPTION, iad.getDescription()));

                    result.add(map);
                }

                controlResults.getComplexResults().put(result);
            } else if (name.equals("injectAllAlertDefinitions")) {
                injectAllAlertDefs(Boolean.valueOf(parameters.getSimpleValue("replaceIfExists")));
            } else if (name.equals("injectAlertDefinition")) {
                InjectedTemplate requestedInjection = new InjectedTemplate(parameters.getSimpleValue(InjectedTemplate.FIELD_PLUGIN_NAME),
                                                                           parameters.getSimpleValue(InjectedTemplate.FIELD_RESOURCE_TYPE_NAME),
                                                                           parameters.getSimpleValue(InjectedTemplate.FIELD_NAME), null);
                boolean injected = false;
                for (InjectedTemplate iad : InjectedTemplatesList.INJECTED_TEMPLATES) {
                    if (iad.equals(requestedInjection)) {
                        injectAlertDef(iad, Boolean.valueOf(parameters.getSimpleValue("replaceIfExists", "false")));
                        injected = true;
                        break;
                    }
                }

                if (!injected) {
                    controlResults.setError("Unknown requested alert definition. Check spelling: " + requestedInjection);
                }
            } else {
                controlResults.setError("Unknown control name: " + name);
            }
        } catch (Throwable t) {
            controlResults.setError(t);
        }

        return controlResults;
    }

    private List<AlertDefinition> injectAllAlertDefs(boolean replaceIfExists) {

        List<AlertDefinition> result = new ArrayList<AlertDefinition>();

        for (InjectedTemplate iad : InjectedTemplatesList.INJECTED_TEMPLATES) {
            AlertDefinition newAlertDef = injectAlertDef(iad, replaceIfExists);
            if (null != newAlertDef) {
                result.add(newAlertDef);
            }
        }

        return result;
    }

    private AlertDefinition injectAlertDef(InjectedTemplate injectedAlertDef, boolean replaceIfExists) {

        AlertDefinition result = null;
        ResourceTypeManagerLocal typeManager = LookupUtil.getResourceTypeManager();
        AlertDefinitionManagerLocal alertDefManager = LookupUtil.getAlertDefinitionManager();
        SubjectManagerLocal subjectManager = LookupUtil.getSubjectManager();

        ResourceTypeCriteria rtc = new ResourceTypeCriteria();
        rtc.addFilterPluginName(injectedAlertDef.getPluginName());
        rtc.addFilterName(injectedAlertDef.getResourceTypeName());
        rtc.fetchMetricDefinitions(true);
        List<ResourceType> resourceTypes = typeManager.findResourceTypesByCriteria(subjectManager.getOverlord(), rtc);

        if (resourceTypes.isEmpty()) {
            return result;
        }

        assert 1 == resourceTypes.size() : "Found more than 1 resource type!";
        ResourceType resourceType = resourceTypes.get(0);

        AlertDefinitionCriteria adc = new AlertDefinitionCriteria();
        adc.addFilterName(injectedAlertDef.getName());
        adc.addFilterAlertTemplateResourceTypeId(resourceType.getId());
        List<AlertDefinition> alertDefs = alertDefManager.findAlertDefinitionsByCriteria(subjectManager.getOverlord(), adc);

        if (!alertDefs.isEmpty()) {
            assert 1 == alertDefs.size() : "Found more than 1 existing alert def!";

            if (!replaceIfExists) {
                return result;
            }

            int[] alertDefIdArray = new int[1];
            alertDefIdArray[0] = alertDefs.get(0).getId();
            alertDefManager.removeAlertDefinitions(subjectManager.getOverlord(), alertDefIdArray);
        }

        int newAlertDefId = injectedAlertDef.inject(resourceType);
        adc.addFilterId(newAlertDefId);

        alertDefs = alertDefManager.findAlertDefinitionsByCriteria(subjectManager.getOverlord(), adc);
        assert 1 == alertDefs.size() : "Found more than 1 new alert def!";
        result = alertDefs.get(0);

        return result;
    }
}
