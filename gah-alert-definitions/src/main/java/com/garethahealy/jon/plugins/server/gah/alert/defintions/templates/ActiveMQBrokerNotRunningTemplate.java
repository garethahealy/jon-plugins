package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.InjectedTemplate;

import org.rhq.core.domain.resource.ResourceType;

public class ActiveMQBrokerNotRunningTemplate extends InjectedTemplate {

    public ActiveMQBrokerNotRunningTemplate() {
        super("Platforms", "Linux", "LinuxVmNotRunning", "The linux VM is not running");
    }

    @Override
    public int inject(ResourceType resourceType) {
        //TODO
        return 0;
    }
}
