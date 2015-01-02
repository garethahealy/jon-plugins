import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class JmxApp {
    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        // register the first with a fully static, hardcoded object name
        MyJmxObject bean1 = new MyJmxObject();
        ObjectName name1 = new ObjectName("jmxapp:type=MyJmxObject,id=static");
        mbs.registerMBean(bean1, name1);
        System.out.println("MBean named [" + name1 + "] has been deployed.");

        // register the second with a dynamic, ordered object name defined at runtime
        MyJmxObject bean2 = new MyJmxObject();
        ObjectName name2 = new ObjectName("jmxapp:type=MyJmxObject,code=" + 1);
        mbs.registerMBean(bean2, name2);
        System.out.println("MBean named [" + name2 + "] has been deployed.");

        // register the third with a dynamic, ordered object name defined at runtime
        MyJmxObject bean3 = new MyJmxObject();
        ObjectName name3 = new ObjectName("jmxapp:type=MyJmxObject,code=" + 2);
        mbs.registerMBean(bean3, name3);
        System.out.println("MBean named [" + name3 + "] has been deployed.");

        // register the fourth with a dynamic, random object name defined at runtime
        MyJmxObject bean4 = new MyJmxObject();
        ObjectName name4 = new ObjectName("jmxapp:type=MyJmxObject,random=" + bean4.hashCode());
        mbs.registerMBean(bean4, name4);
        System.out.println("MBean named [" + name4 + "] has been deployed.");

        // wait indefinintely until someone kills us
        synchronized(JmxApp.class) {
           JmxApp.class.wait();
        }
    }
}
