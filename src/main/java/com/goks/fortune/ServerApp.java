package com.goks.fortune;

import com.goks.fortune.health.TemplateHealthCheck;
import com.goks.fortune.resources.ScheduleResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Gokul
 *
 */
public class ServerApp extends Application<InitialConfiguration> {

	/**
	 * @param args input.
	 * @throws Exception during call
	 */
	public static void main(final String[] args) throws Exception {
		new ServerApp().run(args);
	}

	/* (non-Javadoc)
	 * @see io.dropwizard.Application#getName()
	 */
	@Override
	public final String getName() {
		return "hello-world";
	}

	/* (non-Javadoc)
	 * @see io.dropwizard.Application#initialize(
	 * io.dropwizard.setup.Bootstrap)
	 */
	@Override
	public final void
		initialize(final Bootstrap<InitialConfiguration> bootstrap) {
		// nothing to do yet
	}

	/* (non-Javadoc)
	 * @see io.dropwizard.Application#run(io.dropwizard.Configuration,
	 * io.dropwizard.setup.Environment)
	 */
	@Override
	public final void run(final InitialConfiguration configuration,
		final Environment environment) throws Exception {
		final ScheduleResource resource = new ScheduleResource(
			configuration.getTemplate(),
			configuration.getDefaultName());
		environment.jersey().register(resource);

		final TemplateHealthCheck healthCheck = new
			TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}
}
