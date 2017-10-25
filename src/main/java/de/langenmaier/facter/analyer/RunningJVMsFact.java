package de.langenmaier.facter.analyer;

import java.util.ArrayList;
import java.util.List;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import de.langenmaier.facter.Fact;
import de.langenmaier.facter.FactAnalyzer;
import de.langenmaier.facter.base.JVMFact;

public class RunningJVMsFact extends Fact implements FactAnalyzer {
	
	public RunningJVMsFact() {
		setSubFacts(new ArrayList<Fact>());
	}

	public void retrieveFactInformation() {
		setFactName("RunningJVMsInformation");
	    List<VirtualMachineDescriptor> descriptors = VirtualMachine.list();
	    for (VirtualMachineDescriptor descriptor : descriptors) {
	        try {
	            VirtualMachine vm = VirtualMachine.attach(descriptor);
	            getSubFacts().add(new JVMFact(descriptor.displayName(), vm));
	        }
	        catch (Exception e) {
	        }
	    }

	}

}
