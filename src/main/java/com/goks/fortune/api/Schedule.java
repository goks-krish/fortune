package com.goks.fortune.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Schedule {
	private long id;

    @Length(max = 3)
    private String content;

    public Schedule() {
        // Jackson deserialization
    }

    public Schedule(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
