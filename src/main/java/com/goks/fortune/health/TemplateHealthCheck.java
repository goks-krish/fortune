package com.goks.fortune.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author Gokul
 *
 */
public class TemplateHealthCheck extends HealthCheck {

	/**
	 * Template data variable.
	 */
	private final String template;

	/**
	 * @param templateData for init template.
	 */
	public TemplateHealthCheck(final String templateData) {
		this.template = templateData;
	}

	/* (non-Javadoc)
	 * @see com.codahale.metrics.health.HealthCheck#check()
	 */
	@Override
	protected final Result check() throws Exception {
		final String saying = String.format(template, "TEST");
		if (!saying.contains("TEST")) {
			return Result.unhealthy(
				"template doesn't include a name");
		}
		return Result.healthy();
	}

}
