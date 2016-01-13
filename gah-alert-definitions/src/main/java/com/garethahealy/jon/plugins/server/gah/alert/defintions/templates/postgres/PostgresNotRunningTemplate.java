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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.postgres;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.alert.AlertCondition;
import org.rhq.core.domain.alert.AlertConditionCategory;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.AlertPriority;
import org.rhq.core.domain.alert.BooleanExpression;
import org.rhq.core.domain.resource.ResourceType;

public class PostgresNotRunningTemplate extends InjectedTemplate {

    private static final String DOWN_NAME = "AVAIL_GOES_DOWN";
    private static final String NOT_UP_NAME = "AVAIL_GOES_NOT_UP";
    private static final String DISABLED_NAME = "AVAIL_GOES_DISABLED";
    private static final String UNKNOWN_NAME = "AVAIL_GOES_UNKNOWN";

    public PostgresNotRunningTemplate() {
        super("Postgres", "Postgres Server", "PostgresNotRunning", "A postgres db is down, not up, disabled or unknown");
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

        int newTemplateId = create(resourceType, alertDefinition);
        return newTemplateId;
    }

    private AlertCondition getDoesDownAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(DOWN_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    private AlertCondition getNotUpAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(NOT_UP_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    private AlertCondition getDisabledAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(DISABLED_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }

    private AlertCondition getUnknownAlertCondition() {
        AlertCondition alertCondition = new AlertCondition();
        alertCondition.setName(UNKNOWN_NAME);
        alertCondition.setCategory(AlertConditionCategory.AVAILABILITY);

        return alertCondition;
    }
}
