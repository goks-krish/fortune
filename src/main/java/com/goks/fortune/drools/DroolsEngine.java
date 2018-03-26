package com.goks.fortune.drools;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;

import com.goks.fortune.model.DailySchedule;

public interface DroolsEngine {

	public DailySchedule[] executeDrools(int totalEmployees, int totalDays, boolean random, String rulesFile)
			throws DroolsParserException, IOException;

}
