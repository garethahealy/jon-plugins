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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter;

import java.util.Map;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.measurement.MeasurementDefinition;
import org.rhq.core.domain.resource.ResourceType;

public class NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate extends InjectedTemplate {

    private static final String RECEIVE_ERROR_NAME = "Receive Errors per Minute";
    private static final String RECEIVE_DROPPED_NAME = "Receive Packets Dropped per Minute";
    private static final String TRANSMIT_ERROR_NAME = "Transmit Errors per Minute";
    private static final String TRANSMIT_DROPPED_NAME = "Transmit Packets Dropped per Minute";
    private static final String RECEIVE_ERROR = "rxErrors";
    private static final String RECEIVE_DROPPED = "rxDropped";
    private static final String TRANSMIT_ERROR = "txErrors";
    private static final String TRANSMIT_DROPPED = "txDropped";

    public NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate() {
        super("Platforms", "Network Adapter", "NetworkAdapterReceiveTransmitErrorsDroppedHigh", "A network adapter is receiving/transmitting above average errors/dropped packets");
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
        alertDefinition.addCondition(getReceiveErrorAlertCondition(metricDefinitions));
        alertDefinition.addCondition(getReceiveDroppedAlertCondition(metricDefinitions));
        alertDefinition.addCondition(getTransmittErrorAlertCondition(metricDefinitions));
        alertDefinition.addCondition(getTransmittDroppedAlertCondition(metricDefinitions));

        int newTemplateId = create(resourceType, alertDefinition);
        return newTemplateId;
    }

    private AlertCondition getReceiveErrorAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(RECEIVE_ERROR_NAME);
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(RECEIVE_ERROR)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(RECEIVE_ERROR);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + RECEIVE_ERROR + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }

    private AlertCondition getReceiveDroppedAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(RECEIVE_DROPPED_NAME);
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(RECEIVE_DROPPED)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(RECEIVE_DROPPED);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + RECEIVE_DROPPED + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }

    private AlertCondition getTransmittErrorAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(TRANSMIT_ERROR_NAME);
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(TRANSMIT_ERROR)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(TRANSMIT_ERROR);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + TRANSMIT_ERROR + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }

    private AlertCondition getTransmittDroppedAlertCondition(Map<String, MeasurementDefinition> metricDefinitions) {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(TRANSMIT_DROPPED_NAME);
        alertCondition.setCategory(AlertConditionCategory.BASELINE);
        alertCondition.setComparator(">");
        alertCondition.setThreshold(0.5d);
        if (metricDefinitions.containsKey(TRANSMIT_DROPPED)) {
            MeasurementDefinition measurementDefinition = metricDefinitions.get(TRANSMIT_DROPPED);

            alertCondition.setMeasurementDefinition(measurementDefinition);
            alertCondition.setName(measurementDefinition.getDisplayName());
        } else {
            throw new IllegalArgumentException("MeasurementDefinition " + TRANSMIT_DROPPED + " not found; " + metricDefinitions.keySet());
        }

        return alertCondition;
    }
}