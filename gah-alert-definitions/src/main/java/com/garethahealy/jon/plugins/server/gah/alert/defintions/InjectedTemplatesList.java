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

import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQBrokerClientConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQBrokerConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQBrokerNetworkConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQBrokerNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQBrokerTotalMessagesHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQQueueConsumerCountChangedTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQQueueDeenqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQQueueEnqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQQueueSizeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQTopicConsumerCountChangedTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQTopicDeenqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQTopicEnqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ActiveMQTopicSizeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CPUCoreNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFBusNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFClientOperationCounterAverageResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFClientServiceCounterAverageResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFEndpointNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFServerOperationCounterResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CXFServerServiceCounterResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CamelContextNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CamelEndpointNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.CamelRouteNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ExchangeFailuresTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.ExchangeMeanProcessingTimeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.FabricContainerNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.FileSystemDiskReadHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.FileSystemDiskWriteHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.FileSystemNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.FileSystemSpaceLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.JVMDeadlockedThreadsTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.JVMGarbageCollectionHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.LinuxLoadHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.LinuxMemoryLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.LinuxVmNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.NetworkAdapterBytesReceivedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.NetworkAdapterBytesTransmittedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.NetworkAdapterNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.PostgresNotRunningTemplate;

public final class InjectedTemplatesList {

    public static final List<InjectedTemplate> INJECTED_TEMPLATES;

    static {
        INJECTED_TEMPLATES = new ArrayList<InjectedTemplate>();
        INJECTED_TEMPLATES.add(new ActiveMQBrokerClientConnectorNotRunningTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQBrokerConnectorNotRunningTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQBrokerNetworkConnectorNotRunningTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQBrokerNotRunningTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQBrokerTotalMessagesHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQQueueConsumerCountChangedTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQQueueDeenqueueHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQQueueEnqueueHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQQueueSizeHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQTopicConsumerCountChangedTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQTopicDeenqueueHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQTopicEnqueueHighTemplate());
        INJECTED_TEMPLATES.add(new ActiveMQTopicSizeHighTemplate());
        INJECTED_TEMPLATES.add(new CamelContextNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CamelEndpointNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CamelRouteNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CPUCoreNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CXFBusNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CXFClientOperationCounterAverageResponseTimeTemplate());
        INJECTED_TEMPLATES.add(new CXFClientServiceCounterAverageResponseTimeTemplate());
        INJECTED_TEMPLATES.add(new CXFEndpointNotRunningTemplate());
        INJECTED_TEMPLATES.add(new CXFServerOperationCounterResponseTimeTemplate());
        INJECTED_TEMPLATES.add(new CXFServerServiceCounterResponseTimeTemplate());
        INJECTED_TEMPLATES.add(new ExchangeFailuresTemplate());
        INJECTED_TEMPLATES.add(new ExchangeMeanProcessingTimeHighTemplate());
        INJECTED_TEMPLATES.add(new FabricContainerNotRunningTemplate());
        INJECTED_TEMPLATES.add(new FileSystemDiskReadHighTemplate());
        INJECTED_TEMPLATES.add(new FileSystemDiskWriteHighTemplate());
        INJECTED_TEMPLATES.add(new FileSystemNotRunningTemplate());
        INJECTED_TEMPLATES.add(new FileSystemSpaceLowTemplate());
        INJECTED_TEMPLATES.add(new JVMDeadlockedThreadsTemplate());
        INJECTED_TEMPLATES.add(new JVMGarbageCollectionHighTemplate());
        INJECTED_TEMPLATES.add(new LinuxLoadHighTemplate());
        INJECTED_TEMPLATES.add(new LinuxMemoryLowTemplate());
        INJECTED_TEMPLATES.add(new LinuxVmNotRunningTemplate());
        INJECTED_TEMPLATES.add(new NetworkAdapterBytesReceivedHighTemplate());
        INJECTED_TEMPLATES.add(new NetworkAdapterBytesTransmittedHighTemplate());
        INJECTED_TEMPLATES.add(new NetworkAdapterNotRunningTemplate());
        INJECTED_TEMPLATES.add(new NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate());
        INJECTED_TEMPLATES.add(new PostgresNotRunningTemplate());
    }

    private InjectedTemplatesList() {

    }
}
