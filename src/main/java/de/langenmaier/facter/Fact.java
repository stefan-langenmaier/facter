package de.langenmaier.facter;

import java.util.List;

public abstract class Fact {
	String factName;
	String factValue;
	List<Fact> subFacts;
	
	public String getFactName() {
		return factName;
	}

	public void setFactName(String factName) {
		this.factName = factName;
	}

	public String getFactValue() {
		return factValue;
	}

	public void setFactValue(String factValue) {
		this.factValue = factValue;
	}

	public List<Fact> getSubFacts() {
		return subFacts;
	}

	public void setSubFacts(List<Fact> subFacts) {
		this.subFacts = subFacts;
	}

	@Override
	public String toString() {
		return toStringIndented("");
	}
	
	public String toStringIndented(String indention) {
		if (factValue!=null) {
			return indention + "{\"" + factName + "\":\"" + factValue + "\"}";			
		} else {
			StringBuilder subFactsString = new StringBuilder();
			String delim = "";
			for (Fact sf : getSubFacts()) {
				subFactsString.append(delim).append(sf.toStringIndented(indention + " "));
				delim = ",\n";
			}
			
			return indention + "{\"" + factName + "\":[\n" + subFactsString + "\n" + indention + "]}";
		}
	}
	
	

}
