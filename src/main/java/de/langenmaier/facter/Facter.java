package de.langenmaier.facter;

import java.util.ArrayList;
import java.util.List;

import de.langenmaier.facter.analyer.RunningJVMsFact;
import de.langenmaier.facter.analyer.SelfFact;
import de.langenmaier.facter.analyer.SystemPropertiesFact;

public class Facter 
{
	static List<Fact> facts = new ArrayList<Fact>();
    public static void main( String[] args )
    {
        Facter.load(facts);
        Facter.get(facts);
        Facter.print(facts);
    }
    
	private static void print(List<Fact> facts2) {
		for (Fact f : facts) {
			System.out.println(f);
		}
	}

	private static void get(List<Fact> facts) {
		for (Fact f : facts) {
			if (f instanceof FactAnalyzer) {
				((FactAnalyzer) f).retrieveFactInformation();
			}
		}
		
	}

	private static void load(List<Fact> facts) {
		facts.add(new SelfFact());
		facts.add(new SystemPropertiesFact());
		facts.add(new RunningJVMsFact());
	}
}
