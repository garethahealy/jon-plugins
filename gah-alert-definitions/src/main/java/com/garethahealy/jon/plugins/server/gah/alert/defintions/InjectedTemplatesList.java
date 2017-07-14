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
package com.garethahealy.jon.plugins.server.gah.alert.defintions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.broker.ActiveMQBrokerClientConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.broker.ActiveMQBrokerConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.broker.ActiveMQBrokerNetworkConnectorNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.broker.ActiveMQBrokerNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.broker.ActiveMQBrokerTotalMessagesHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.queue.ActiveMQQueueConsumerCountChangedTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.queue.ActiveMQQueueDequeueLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.queue.ActiveMQQueueEnqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.queue.ActiveMQQueueSizeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.topic.ActiveMQTopicConsumerCountChangedTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.topic.ActiveMQTopicDequeueLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.topic.ActiveMQTopicEnqueueHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.activemq.topic.ActiveMQTopicSizeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.camel.CamelContextNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.camel.CamelEndpointNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.camel.CamelExchangeFailuresTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.camel.CamelExchangeMeanProcessingTimeHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.camel.CamelRouteNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cpu.CPUCoreNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFBusNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFClientOperationCounterAverageResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFClientServiceCounterAverageResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFEndpointNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFServerOperationCounterResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.cxf.CXFServerServiceCounterResponseTimeTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.fabric.FabricContainerNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.filesystem.FileSystemDiskReadHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.filesystem.FileSystemDiskWriteHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.filesystem.FileSystemNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.filesystem.FileSystemSpaceLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.jvm.JVMDeadlockedThreadsTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.jvm.JVMGarbageCollectionHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.linux.LinuxLoadHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.linux.LinuxMemoryLowTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.linux.LinuxVmNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter.NetworkAdapterBytesReceivedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter.NetworkAdapterBytesTransmittedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter.NetworkAdapterNotRunningTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter.NetworkAdapterReceiveTransmitErrorsDroppedHighTemplate;
import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.postgres.PostgresNotRunningTemplate;

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
        temp.add(new ActiveMQQueueDequeueLowTemplate());
        temp.add(new ActiveMQQueueEnqueueHighTemplate());
        temp.add(new ActiveMQQueueSizeHighTemplate());
        temp.add(new ActiveMQTopicConsumerCountChangedTemplate());
        temp.add(new ActiveMQTopicDequeueLowTemplate());
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
        temp.add(new CamelExchangeFailuresTemplate());
        temp.add(new CamelExchangeMeanProcessingTimeHighTemplate());
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
