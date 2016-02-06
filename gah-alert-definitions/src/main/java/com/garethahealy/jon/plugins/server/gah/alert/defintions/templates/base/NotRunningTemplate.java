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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.base;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDampening;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.resource.ResourceType;

public class NotRunningTemplate extends InjectedTemplate {

    public NotRunningTemplate(String pluginName, String resourceTypeName, String name, String description) {
        super(pluginName, resourceTypeName, name, description);
    }

    @Override
    public int inject(ResourceType resourceType) {
        AlertDefinition alertDefinition = new AlertDefinition();
        alertDefinition.setName(getName());
        alertDefinition.setResourceType(resourceType);
        alertDefinition.setPriority(AlertPriority.MEDIUM);
        alertDefinition.setConditionExpression(BooleanExpression.ANY);
        alertDefinition.setDescription(getDescription());
        alertDefinition.setRecoveryId(0);
        alertDefinition.setEnabled(true);
        alertDefinition.addCondition(getDoesDownAlertCondition());
        alertDefinition.addCondition(getNotUpAlertCondition());
        alertDefinition.addCondition(getDisabledAlertCondition());
        alertDefinition.addCondition(getUnknownAlertCondition());
        alertDefinition.setAlertDampening(getNoneAlertDampening());

        int newTemplateId = create(resourceType, alertDefinition);
        return newTemplateId;
    }

    protected AlertCondition getDoesDownAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(DOWN_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    protected AlertCondition getNotUpAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(NOT_UP_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    protected AlertCondition getDisabledAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(DISABLED_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    protected AlertCondition getUnknownAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(UNKNOWN_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }
}
