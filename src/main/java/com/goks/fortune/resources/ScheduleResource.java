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
    public Schedule sendSchedule(@QueryParam("name") Optional<String> name) {
        //final String value = String.format(template, name.orElse(defaultName));
    	DailySchedule[] value = null;
		try {
			value = droolsEngine.executeDrools(10, 14, false);
		} catch (DroolsParserException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new Schedule(util.getHostName()+" - "+counter.incrementAndGet(), value);
    }
}
