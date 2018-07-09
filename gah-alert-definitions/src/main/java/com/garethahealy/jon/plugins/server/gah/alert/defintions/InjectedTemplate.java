/*
 * #%L
 * GarethHealy :: JBoss ON :: Plugins :: GAH Alert Definitions
 * %%
 * Copyright (C) 2013 - 2018 Gareth Healy
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

import org.rhq.core.domain.alert.AlertDampening;
import org.rhq.core.domain.alert.AlertDefinition;
import org.rhq.core.domain.alert.notification.AlertNotification;
import org.rhq.core.domain.configuration.Configuration;
import org.rhq.core.domain.configuration.RawConfiguration;
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

    protected static final String OPTION_STATUS_AVERAGE = "mean";

    protected static final String TOTAL_MESSAGE = "TotalMessageCount";
    protected static final String DOWN_NAME = "AVAIL_GOES_DOWN";
    protected static final String NOT_UP_NAME = "AVAIL_GOES_NOT_UP";
    protected static final String DISABLED_NAME = "AVAIL_GOES_DISABLED";
    protected static final String UNKNOWN_NAME = "AVAIL_GOES_UNKNOWN";
    protected static final String CONSUMER_COUNT = "ConsumerCount";
    protected static final String QUEUE_SIZE = "QueueSize";
    protected static final String DEQUEUE_COUNT = "DequeueCount";
    protected static final String ENQUEUE_COUNT = "EnqueueCount";
    protected static final String EXCHANGED_FAILED = "ExchangesFailed";
    protected static final String MEAN_TIME = "MeanProcessingTime";
    protected static final String AVERAGE_RESPONSE = "AvgResponseTime";
    protected static final String DISK_READS = "fileSystemUsage.diskReads";
    protected static final String DISK_WRITES = "fileSystemUsage.diskWrites";
    protected static final String USED_PERC = "fileSystemUsage.usePercent";
    protected static final String DEADLOCKED_COUNT = "DeadLockedThreadCount";
    protected static final String COLLECTION_TIME = "CollectionTime";
    protected static final String SYS_LOAD = "CpuPerc.sys";
    protected static final String USER_LOAD = "CpuPerc.user";
    protected static final String FREE_MEMORY = "Native.MemoryInfo.actualFree";
    protected static final String FREE_SWAP = "Native.SwapInfo.free";
    protected static final String BYTES_RECEIVE = "rxBytes";
    protected static final String BYTES_TRANSMIT = "txBytes";
    protected static final String RECEIVE_ERROR = "rxErrors";
    protected static final String RECEIVE_DROPPED = "rxDropped";
    protected static final String TRANSMIT_ERROR = "txErrors";
    protected static final String TRANSMIT_DROPPED = "txDropped";

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

    protected AlertDampening getNoneAlertDampening() {
        return new AlertDampening(AlertDampening.Category.NONE);
    }

    protected AlertNotification getDefaultAlertNotification() {
        Configuration emailConfig = new Configuration();
        emailConfig.setSimpleValue("emailAddress", "bob@bob.com");
        
        return new AlertNotification("Direct Emails", emailConfig);
    }

    @Override
    public int hashCode() {
        int result = pluginName != null ? pluginName.hashCode() : 0;
        result = 31 * result + (resourceTypeName != null ? resourceTypeName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InjectedTemplate that = (InjectedTemplate)o;

        if (pluginName != null ? !pluginName.equals(that.pluginName) : that.pluginName != null) {
            return false;
        }

        if (resourceTypeName != null ? !resourceTypeName.equals(that.resourceTypeName) : that.resourceTypeName != null) {
            return false;
        }

        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public String toString() {
        return "InjectedAlertDef [pluginName=" + pluginName + ", resourceTypeName=" + resourceTypeName + ", name="
               + name + "]";
    }
}
