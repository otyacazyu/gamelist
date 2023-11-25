package com.example.gamelist;

public class GameName {

    private final int id;
    private final String name;

    public GameName(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
