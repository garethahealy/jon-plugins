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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf;

import java.util.Map;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.measurement.MeasurementDefinition;
import org.rhq.core.domain.resource.ResourceType;

public class CXFClientOperationCounterAverageResponseTimeTemplate extends InjectedTemplate {

    private static final String AVERAGE_RESPONSE_NAME = "Average Response Time";
    private static final String AVERAGE_RESPONSE = "AvgResponseTime";

    public CXFClientOperationCounterAverageResponseTimeTemplate() {
        super("CXF", "CamelExchangeMeanProcessingTimeHighTemplate", "CXFClientOperationCounterAverageResponseTime", "CXF response time is high");
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
        alertDefinition.addCondition(getAverageResponseAlertCondition(metricDefinitions));
        alertDefinition.setAlertDampening(getNoneAlertDampening());

        int newTemplateId = create(resourceType, alertDefinition);
        return newTemplateId;
    }

    private AlertCondition getAverageResponseAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(AVERAGE_RESPONSE_NAME);
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(AVERAGE_RESPONSE)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(AVERAGE_RESPONSE);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + AVERAGE_RESPONSE + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }
}
