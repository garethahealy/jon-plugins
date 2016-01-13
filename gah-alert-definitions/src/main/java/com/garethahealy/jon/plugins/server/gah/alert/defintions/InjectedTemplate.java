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

import java.util.HashMap;
import java.util.Map;

import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.measurement.MeasurementDefinition;
import org.rhq.core.domain.resource.ResourceType;
import org.rhq.enterprise.server.alert.AlertTemplateManagerLocal;
import org.rhq.enterprise.server.auth.SubjectManagerLocal;
import org.rhq.enterprise.server.util.LookupUtil;

public class InjectedTemplate {

    public static final String FIELD_PLUGIN_NAME = "plugin";
    public static final String FIELD_RESOURCE_TYPE_NAME = "type";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";

    private String pluginName;
    private String resourceTypeName;
    private String name;
    private String description;

    public InjectedTemplate(String pluginName, String resourceTypeName, String name, String description) {
        super();
        this.pluginName = pluginName;
        this.resourceTypeName = resourceTypeName;
        this.name = name;
        this.description = description;
    }

    public String getPluginName() {
        return pluginName;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected Map<String, MeasurementDefinition> getMetricDefinitionsMap(ResourceType resourceType) {
        Map<String, MeasurementDefinition> map = new HashMap<String, MeasurementDefinition>();
        for (MeasurementDefinition value : resourceType.getMetricDefinitions()) {
            map.put(value.getName(), value);
        }

        return map;
    }

    public int inject(ResourceType resourceType) {
        throw new IllegalArgumentException("Not implemented");
    }

    protected int create(ResourceType resourceType, AlertDefinition alertDefinition) {
        AlertTemplateManagerLocal alertTemplateManager = LookupUtil.getAlertTemplateManager();
        SubjectManagerLocal subjectManager = LookupUtil.getSubjectManager();

        int newTemplateId = alertTemplateManager.createAlertTemplate(subjectManager.getOverlord(), alertDefinition, resourceType.getId());
        return newTemplateId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((pluginName == null) ? 0 : pluginName.hashCode());
        result = prime * result + ((resourceTypeName == null) ? 0 : resourceTypeName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InjectedTemplate other = (InjectedTemplate)obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (pluginName == null) {
            if (other.pluginName != null) {
                return false;
            }
        } else if (!pluginName.equals(other.pluginName)) {
            return false;
        }
        if (resourceTypeName == null) {
            if (other.resourceTypeName != null) {
                return false;
            }
        } else if (!resourceTypeName.equals(other.resourceTypeName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InjectedAlertDef [pluginName=" + pluginName + ", resourceTypeName=" + resourceTypeName + ", name="
               + name + "]";
    }
}
