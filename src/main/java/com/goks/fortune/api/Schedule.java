package com.goks.fortune.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goks.fortune.model.DailySchedule;

/**
 * @author Gokul
 *
 */
public class Schedule {
	/**
	 * Id field for the request.
	 */
	private String id;

	/**
	 * Schedule field for the request.
	 */
	private DailySchedule[] schedule;

	/**
	 * Jackson Deserialize.
	 */
	public Schedule() {
		// Jackson deserialization
	}

	/**
	 * @param idData for count of requests.
	 * @param sched output for request.
	 */
	public Schedule(final String idData, final DailySchedule[] sched) {
		this.id = idData;
		this.schedule = sched;
	}

	/**
	 * @return id for each request.
	 */
	@JsonProperty
	public final String getId() {
		return id;
	}

	/**
	 * @return Schedule for request.
	 */
	@JsonProperty
	public final DailySchedule[] getSchedule() {
		return schedule;
	}
}
