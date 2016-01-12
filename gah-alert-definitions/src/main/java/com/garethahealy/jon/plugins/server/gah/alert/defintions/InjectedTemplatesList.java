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
import java.util.Collections;
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
        List<InjectedTemplate> temp = new ArrayList<InjectedTemplate>();
        temp.add(new ActiveMQBrokerClientConnectorNotRunningTemplate());
        temp.add(new ActiveMQBrokerConnectorNotRunningTemplate());
        temp.add(new ActiveMQBrokerNetworkConnectorNotRunningTemplate());
        temp.add(new ActiveMQBrokerNotRunningTemplate());
        temp.add(new ActiveMQBrokerTotalMessagesHighTemplate());
        temp.add(new ActiveMQQueueConsumerCountChangedTemplate());
        temp.add(new ActiveMQQueueDeenqueueHighTemplate());
        temp.add(new ActiveMQQueueEnqueueHighTemplate());
        temp.add(new ActiveMQQueueSizeHighTemplate());
        temp.add(new ActiveMQTopicConsumerCountChangedTemplate());
        temp.add(new ActiveMQTopicDeenqueueHighTemplate());
        temp.add(new ActiveMQTopicEnqueueHighTemplate());
        temp.add(new ActiveMQTopicSizeHighTemplate());
        temp.add(new CamelContextNotRunningTemplate());
        temp.add(new CamelEndpointNotRunningTemplate());
        temp.add(new CamelRouteNotRunningTemplate());
        temp.add(new CPUCoreNotRunningTemplate());
        temp.add(new CXFBusNotRunningTemplate());
        temp.add(new CXFClientOperationCounterAverageResponseTimeTemplate());
        temp.add(new CXFClientServiceCounterAverageResponseTimeTemplate());
        temp.add(new CXFEndpointNotRunningTemplate());
        temp.add(new CXFServerOperationCounterResponseTimeTemplate());
        temp.add(new CXFServerServiceCounterResponseTimeTemplate());
        temp.add(new ExchangeFailuresTemplate());
        temp.add(new ExchangeMeanProcessingTimeHighTemplate());
        temp.add(new FabricContainerNotRunningTemplate());
        temp.add(new FileSystemDiskReadHighTemplate());
        temp.add(new FileSystemDiskWriteHighTemplate());
        temp.add(new FileSystemNotRunningTemplate());
        temp.add(new FileSystemSpaceLowTemplate());
        temp.add(new JVMDeadlockedThreadsTemplate());
        temp.add(new JVMGarbageCollectionHighTemplate());
        temp.add(new LinuxLoadHighTemplate());
        temp.add(new LinuxMemoryLowTemplate());
        temp.add(new LinuxVmNotRunningTemplate());
        temp.add(new NetworkAdapterBytesReceivedHighTemplate());
        temp.add(new NetworkAdapterBytesTransmittedHighTemplate());
        temp.add(new NetworkAdapterNotRunningTemplate());
        temp.add(new NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate());
        temp.add(new PostgresNotRunningTemplate());

        INJECTED_TEMPLATES = Collections.unmodifiableList(temp);
    }

    private InjectedTemplatesList() {

    }
}
