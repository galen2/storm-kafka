/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package storm.kafka;

import java.io.Serializable;
import java.util.List;

import clojure.main;


public class SpoutConfig extends KafkaConfig implements Serializable {
    public List<String> zkServers = null;
    public Integer zkPort = null;
    public String zkRoot = null;
    public String id = null;

    // setting for how often to save the current kafka offset to ZooKeeper
    public long stateUpdateIntervalMs = 2000;

    // Exponential back-off retry settings.  These are used when retrying messages after a bolt
    // calls OutputCollector.fail().
    public long retryInitialDelayMs = 0;
    public double retryDelayMultiplier = 1.0;
    public long retryDelayMaxMs = 60 * 1000;

    public SpoutConfig(BrokerHosts hosts, String topic, String zkRoot, String id) {
    	super(hosts, topic);
    	this.zkRoot = zkRoot;
    	this.id = id;
    }
    
    
    
    public SpoutConfig(BrokerHosts hosts, String topic, String zkRoot, String id, List<String> zkServers,Integer zkPort) {
        super(hosts, topic);
        this.zkRoot = zkRoot;
        this.id = id;
        this.zkServers = zkServers;
        this.zkPort = zkPort;
    }
    
    
    
    
}
