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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates;

import java.util.ArrayList;
import java.util.List;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.measurement.MeasurementDefinition;
import org.rhq.core.domain.resource.ResourceType;

public class LinuxVmNotRunningTemplate extends InjectedTemplate {

    public LinuxVmNotRunningTemplate() {
        super("Platforms", "Linux", "LinuxVmNotRunning", "The linux VM is not running");
    }

    @Override
    public int inject(ResourceType resourceType) {
        AlertCondition dataDiskUsedAlertCondition = new AlertCondition();
        dataDiskUsedAlertCondition.setCategory(AlertConditionCategory.THRESHOLD);
        dataDiskUsedAlertCondition.setComparator(">");
        dataDiskUsedAlertCondition.setThreshold(0.5D);

        AlertDefinition newTemplate = new AlertDefinition();
        newTemplate.setName(getName());
        newTemplate.setResourceType(resourceType);
        newTemplate.setPriority(AlertPriority.MEDIUM);
        newTemplate.setConditionExpression(BooleanExpression.ANY);
        newTemplate.setDescription(getDescription());
        newTemplate.setRecoveryId(0);
        newTemplate.setEnabled(true);
        newTemplate.addCondition(dataDiskUsedAlertCondition);
        
        for (MeasurementDefinition d : resourceType.getMetricDefinitions()) {
            if ("todo".equals(d.getName())) {
                dataDiskUsedAlertCondition.setMeasurementDefinition(d);
                dataDiskUsedAlertCondition.setName(d.getDisplayName());
            }
        }

        int newTemplateId = create(resourceType, newTemplate, dataDiskUsedAlertCondition);
        return newTemplateId;
    }
}
