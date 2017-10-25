package de.langenmaier.facter.base;

import de.langenmaier.facter.Fact;

public class VersionFact extends Fact {

	public VersionFact(String version) {
		setFactName("version");
		setFactValue(version);
	}

}
