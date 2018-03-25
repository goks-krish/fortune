package com.goks.fortune.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.goks.fortune.model.DailySchedule;

import org.hibernate.validator.constraints.Length;

public class Schedule {
	private String id;

    private DailySchedule[] schedule;

    public Schedule() {
        // Jackson deserialization
    }

    public Schedule(String id, DailySchedule[] schedule) {
        this.id = id;
        this.schedule = schedule;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public DailySchedule[] getSchedule() {
        return schedule;
    }
}
