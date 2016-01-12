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

        List<Integer> measurementDefinitionIds = new ArrayList<Integer>(1);
        for (MeasurementDefinition d : resourceType.getMetricDefinitions()) {
            if ("todo".equals(d.getName())) {
                measurementDefinitionIds.add(d.getId());
                dataDiskUsedAlertCondition.setMeasurementDefinition(d);
                dataDiskUsedAlertCondition.setName(d.getDisplayName());
            }
        }

        int newTemplateId = create(resourceType, newTemplate, dataDiskUsedAlertCondition);
        return newTemplateId;
    }
}
