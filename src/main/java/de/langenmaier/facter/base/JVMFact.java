package de.langenmaier.facter.base;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.sun.tools.attach.VirtualMachine;

import de.langenmaier.facter.Fact;

public class JVMFact extends Fact {

	public JVMFact(String vmName, VirtualMachine vm) {
		setFactName(vmName);
		setSubFacts(new ArrayList<Fact>());

		try {
			for (String name : vm.getSystemProperties().stringPropertyNames())
			getSubFacts().add(new StringFact(name, vm.getSystemProperties().getProperty(name)));

	        String connectorAddress = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
	        if (connectorAddress == null) {
	            vm.startLocalManagementAgent();
	            connectorAddress = vm.getAgentProperties().getProperty("com.sun.management.jmxremote.localConnectorAddress");
	        }
	
	        JMXServiceURL url = new JMXServiceURL(connectorAddress);
	        JMXConnector connector = JMXConnectorFactory.connect(url);
	        MBeanServerConnection mbs = connector.getMBeanServerConnection();
	
	        ObjectName threadName = new ObjectName(ManagementFactory.THREAD_MXBEAN_NAME);
	        Integer threadCount = (Integer)mbs.getAttribute(threadName, "ThreadCount");
	        getSubFacts().add(new StringFact("ThreadCount", threadCount.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
