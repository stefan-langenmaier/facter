package de.langenmaier.facter.analyer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import de.langenmaier.facter.Fact;
import de.langenmaier.facter.FactAnalyzer;
import de.langenmaier.facter.base.VersionFact;

public class SelfFact extends Fact implements FactAnalyzer {
	
	public SelfFact() {
		setSubFacts(new ArrayList<Fact>());
	}

	public void retrieveFactInformation() {
		setFactName("SelfInformation");

		InputStream resourceAsStream =
				this.getClass().getResourceAsStream(
						"/version.properties"
						);
		Properties prop = new Properties();
		try {
			prop.load( resourceAsStream );
		} catch (IOException e) {
			e.printStackTrace();
		}

		getSubFacts().add(new VersionFact(prop.getProperty("version")));

	}

}
