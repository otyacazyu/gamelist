package com.example.gamelist;

public class Game {

    private final int id;
    private final String name;

    public Game(int id, String name) {
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



