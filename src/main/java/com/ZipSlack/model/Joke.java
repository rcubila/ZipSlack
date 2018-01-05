package com.ZipSlack.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {

    private Integer id;
    private String type;
    private String setup;
    private String punchLine;

    public Joke() {}

    public Joke(Integer id, String type, String setup, String punchLine) {
        this.id = id;
        this.type = type;
        this.setup = setup;
        this.punchLine = punchLine;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchLine() {
        return punchLine;
    }
}
