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
package com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.networkadapter;

import com.garethahealy.jon.plugins.server.gah.alert.defintions.templates.base.NotRunningTemplate;

public class NetworkAdapterNotRunningTemplate extends NotRunningTemplate {

    public NetworkAdapterNotRunningTemplate() {
        super("Platforms", "Network Adapter", "NetworkAdapterNotRunning", "A network adapter is down, not up, disabled or unknown");
    }
}
