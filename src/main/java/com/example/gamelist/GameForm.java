package com.example.gamelist;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GameForm {

    private String name;
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public GameForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}



