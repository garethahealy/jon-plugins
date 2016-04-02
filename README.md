[![Build Status](https://travis-ci.org/garethahealy/jon-plugins.svg?branch=master)](https://travis-ci.org/garethahealy/jon-plugins)

# jon-plugins
Collection of JBoss Operations Network (JON) (http://www.redhat.com/en/technologies/jboss-middleware/operations-network) plugins.

## poolcounter-mbeans
Simple example of how to expose a Java MBean to JON via the agent plugin.

## geronimo-poolingattributes-mbeans
Agent plugin to expose Geronimo Pooling attributes, which can be used by Apache ServiceMix to manage database connections.
- http://grepcode.com/project/repo1.maven.org/maven2/org.apache.geronimo.components/geronimo-connector/

## commonspool2-mbeans
Agent plugin to expose Commons Pool2 attributes, which is used by Commons DBCP2 to manage database connections.
- https://commons.apache.org/proper/commons-pool/
- https://commons.apache.org/proper/commons-dbcp/

## gah-alert-definitions
Server plugin to automatically create pre-defined alerts in JON.
