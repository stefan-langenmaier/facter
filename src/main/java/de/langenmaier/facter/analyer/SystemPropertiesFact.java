package de.langenmaier.facter.analyer;

import java.util.ArrayList;

import de.langenmaier.facter.Fact;
import de.langenmaier.facter.FactAnalyzer;
import de.langenmaier.facter.base.StringFact;

public class SystemPropertiesFact extends Fact implements FactAnalyzer {
	
	public SystemPropertiesFact() {
		setSubFacts(new ArrayList<Fact>());
	}

	public void retrieveFactInformation() {
		setFactName("SystemPropertiesInformation");
		for (String name : System.getProperties().stringPropertyNames())
		getSubFacts().add(new StringFact(name, System.getProperties().getProperty(name)));

	}

}
