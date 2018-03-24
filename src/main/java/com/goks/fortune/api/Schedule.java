package com.goks.fortune.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Schedule {
	private long id;

    @Length(max = 3)
    private String schedule;

    public Schedule() {
        // Jackson deserialization
    }

    public Schedule(long id, String schedule) {
        this.id = id;
        this.schedule = schedule;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getSchedule() {
        return schedule;
    }
}
