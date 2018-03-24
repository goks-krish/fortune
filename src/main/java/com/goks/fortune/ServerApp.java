package com.goks.fortune;

import com.goks.fortune.health.TemplateHealthCheck;
import com.goks.fortune.resources.ScheduleResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ServerApp extends Application<InitialConfiguration> {

    
	public static void main(String[] args)  throws Exception  {
		new ServerApp().run(args);
	}

	@Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<InitialConfiguration> bootstrap) {
        // nothing to do yet
    }

	@Override
	public void run(InitialConfiguration configuration, Environment environment) throws Exception {
	    final ScheduleResource resource = new ScheduleResource(
	            configuration.getTemplate(),
	            configuration.getDefaultName()
	        );
	        environment.jersey().register(resource);
        
	        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
            environment.healthChecks().register("template", healthCheck);
            environment.jersey().register(resource);
	}
}
