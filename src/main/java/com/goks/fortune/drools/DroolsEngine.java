/**
 * The interface to implement for drools engine
 */
package com.goks.fortune.drools;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;

import com.goks.fortune.model.DailySchedule;

/**
 * @author Gokul
 *
 */
public interface DroolsEngine {

    /**
     * This method returns the schedule list.
     * @param totalEmployees
     *            Count of total Employes
     * @param totalDays
     *            Total number of days desired
     * @param random
     *            True of randomization to be enabled
     * @param rulesFile
     *            Rules file text
     * @return schedule list array
     * @throws DroolsParserException
     *             When the drools rules fails
     * @throws IOException
     *             When the rules file is has read error
     */
    DailySchedule[] executeDrools(int totalEmployees, int totalDays,
    boolean random, String rulesFile) throws DroolsParserException,
    IOException;
}
