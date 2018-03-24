package com.goks.fortune.drools;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;

public interface DroolsEngine {
	
	public String executeDrools(int totalEmployees, int totalDays, boolean random) throws DroolsParserException, IOException;
	
}
