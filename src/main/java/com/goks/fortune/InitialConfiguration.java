package com.goks.fortune;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Gokul
 *
 */
public class InitialConfiguration extends Configuration {
	/**
	 * Template data.
	 */
	@NotEmpty
	private String template;
	/**
	 * Default name.
	 */
	@NotEmpty
	private String defaultName = "Stranger";
	/**
	 * @return template data.
	 */
	@JsonProperty
	public final String getTemplate() {
		return template;
	}
	/**
	 * @param templateData info
	 */
	@JsonProperty
	public final void setTemplate(final String templateData) {
		this.template = templateData;
	}
	/**
	 * @return default name data.
	 */
	@JsonProperty
	public final String getDefaultName() {
		return defaultName;
	}
	/**
	 * @param nameData info.
	 */
	@JsonProperty
	public final void setDefaultName(final String nameData) {
		this.defaultName = nameData;
	}
}
