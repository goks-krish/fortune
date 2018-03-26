package com.goks.fortune.resources;

import com.goks.fortune.Utility;
import com.goks.fortune.api.Schedule;
import com.goks.fortune.drools.DroolsEngine;
import com.goks.fortune.drools.DroolsEngineImpl;
import com.goks.fortune.model.DailySchedule;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.drools.compiler.compiler.DroolsParserException;

import java.util.concurrent.atomic.AtomicLong;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

/**
 * @author Gokul
 *
 */
@Path("/schedule")
@Produces(MediaType.APPLICATION_JSON)
public class ScheduleResource {
	/**
	 * Counter for number of requests.
	 */
	private final AtomicLong counter;
	/**
	 * Variable to call utility.
	 */
	private final Utility util;
	/**
	 * Variable to call DroolsEngine.
	 */
	private final DroolsEngine droolsEngine;

	/**
	 * Default number of employees.
	 */
	public static final int DEFAULT_EMPLOYEES = 10;
	/**
	 * Default number of days.
	 */
	public static final int DEFAULT_DAYS = 14;
	/**
	 * @param template Default template data.
	 * @param defaultName Default Name data.
	 */
	public ScheduleResource(final String template,
		final String defaultName) {
		this.counter = new AtomicLong();
		this.droolsEngine = new DroolsEngineImpl();
		this.util = new Utility();
	}

	/**
	 * @param totalEmployees Upper limit for employees.
	 * @param totalDays Upper limit for days.
	 * @param random with true or false for random.
	 * @param rules with rules data.
	 * @return schedule array for final schedule.
	 */
	@GET
	@Timed
	public final Schedule sendSchedule(
		@QueryParam("employeeCount") final int totalEmployees,
		@QueryParam("totalDays") final int totalDays,
		@QueryParam("random") final Optional<Boolean> random,
		@QueryParam("rules") final String rules) {
		DailySchedule[] value = null;
		try {
		    	int empTotal = totalEmployees;
		    	int dayTotal = totalDays;
			if (empTotal <= 0) {
			    empTotal = DEFAULT_EMPLOYEES;
			}
			if (dayTotal <= 0) {
			    dayTotal = DEFAULT_DAYS;
			}
			String rulesFile = "rules.drl";

			if (rules != null && rules.toString().length() != 0) {
				rulesFile = "rules-temp.drl";
				File newTextFile = new File(rulesFile);
				FileWriter fw = new FileWriter(newTextFile);
				fw.write(rules);
				fw.close();
			}

			value = droolsEngine.executeDrools(empTotal,
				dayTotal, random.isPresent(), rulesFile);
		} catch (DroolsParserException | IOException e) {
			e.printStackTrace();
		}
		return new Schedule(util.getHostName() + " - "
		+ counter.incrementAndGet(), value);
	}
}
