This source code is originally from: https://docs.jboss.org/author/display/RHQ/Plugins+-+Demos+-+Writing+Custom+JMX+Plugin

This contains two pieces of software necessary to run the "Custom JMX Plugin"
demo: the sample JMX application and the custom JMX plugin.

* jmx-app
A very simple J2SE app that registers a few MBeans in a MBeanServer that can be
accessed remotely via jconsole or RHQ/Jopr.  The source is included if you want
to build it yourself; a prebuilt binary with a script is also included so you
can run it without building it. See jmx-app/prebuilt.

* custom-jmx-plugin
The custom JMX plugin that can be used to deploy in a RHQ/Jopr Server.  This
plugin can manage and monitor the MBeans deployed in the sample JMX
application. You can "mvn install" this, or use the prebuilt jar found in
custom-jmx-plugin/target.
