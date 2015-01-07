jon-plugins
===========
Collection of JBoss Operations Network (JON) (http://www.redhat.com/en/technologies/jboss-middleware/operations-network) plugins

future
===========
Make the plugins a bit "clever" so that certain parts are auto discovered

i.e.: 'org.apache.commons.pool2:type=GenericObjectPool,name=pool' would become 'org.apache.commons.pool2:type=${type.name},name=${name}'

This means if we have mutiple pools in the future, they will all be displayed
