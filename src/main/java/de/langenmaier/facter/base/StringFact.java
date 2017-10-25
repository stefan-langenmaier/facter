package de.langenmaier.facter.base;

import de.langenmaier.facter.Fact;

public class StringFact extends Fact {
	public StringFact(String factName, String factValue) {
		setFactName(factName);
		factValue = factValue.replaceAll("\t", "\\\\t");
		factValue = factValue.replaceAll("\n", "\\\\r");
		factValue = factValue.replaceAll("\r", "\\\\n");
		factValue = factValue.replaceAll("\b", "\\\\b");
		factValue = factValue.replaceAll("\f", "\\\\f");
		factValue = factValue.replaceAll("\\\\", "\\\\");
		setFactValue(factValue);
	}
}
