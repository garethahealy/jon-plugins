/*
 * #%L
 * GarethHealy :: JBoss ON :: Plugins :: GAH Alert Definitions
 * %%
 * Copyright (C) 2013 - 2017 Gareth Healy
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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.linux;

import java.util.Map;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.measurement.MeasurementDefinition;
import org.rhq.core.domain.resource.ResourceType;

public class LinuxLoadHighTemplate extends InjectedTemplate {

    public LinuxLoadHighTemplate() {
        super("Platforms", "Linux", "LinuxLoadHigh", "The linux VM has high system and user load.");
    }

    @Override
    public int inject(ResourceType resourceType) {
        Map<String, MeasurementDefinition> metricDefinitions = getMetricDefinitionsMap(resourceType);

        AlertDefinition alertDefinition = new AlertDefinition();
        alertDefinition.setName(getName());
        alertDefinition.setResourceType(resourceType);
        alertDefinition.setPriority(AlertPriority.MEDIUM);
        alertDefinition.setConditionExpression(BooleanExpression.ANY);
        alertDefinition.setDescription(getDescription());
        alertDefinition.setRecoveryId(0);
        alertDefinition.setEnabled(true);
        alertDefinition.addCondition(getSysLoadAlertCondition(metricDefinitions));
        alertDefinition.addCondition(getUserLoadAlertCondition(metricDefinitions));
        alertDefinition.setAlertDampening(getNoneAlertDampening());

        int newTemplateId = create(resourceType, alertDefinition);
        return newTemplateId;
    }

    private AlertCondition getSysLoadAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(SYS_LOAD)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(SYS_LOAD);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + SYS_LOAD + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }

    private AlertCondition getUserLoadAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        alertCondition.setOption(OPTION_STATUS_AVERAGE);
        if (metricDefinitions.containsKey(USER_LOAD)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(USER_LOAD);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + USER_LOAD + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }
}
