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

@Path("/schedule")
@Produces(MediaType.APPLICATION_JSON)
public class ScheduleResource {
	private final AtomicLong counter;
	private final Utility util;
	DroolsEngine droolsEngine;

	public ScheduleResource(String template, String defaultName) {
		this.counter = new AtomicLong();
		this.droolsEngine = new DroolsEngineImpl();
		this.util = new Utility();
	}

	@GET
	@Timed
	public Schedule sendSchedule(@QueryParam("employeeCount") int totalEmployees,
			@QueryParam("totalDays") int totalDays, @QueryParam("random") Optional<Boolean> random,
			@QueryParam("rules") String rules) {
		// final String value = String.format(template, name.orElse(defaultName));
		DailySchedule[] value = null;
		try {
			if (totalEmployees <= 0) {
				totalEmployees = 10;
			}
			if (totalDays <= 0) {
				totalDays = 14;
			}
			String rulesFile = "rules.drl";

			if (rules != null && rules.toString().length() != 0) {
				rulesFile = "rules-temp.drl";
				File newTextFile = new File(rulesFile);
				FileWriter fw = new FileWriter(newTextFile);
				fw.write(rules);
				fw.close();
			}

			value = droolsEngine.executeDrools(totalEmployees, totalDays, random.isPresent(), rulesFile);
		} catch (DroolsParserException | IOException e) {
			e.printStackTrace();
		}
		return new Schedule(util.getHostName() + " - " + counter.incrementAndGet(), value);
	}
}
