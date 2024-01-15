package com.example.gamelist;

public class GameDuplicateException extends RuntimeException {
    public GameDuplicateException(String massage) {
        super(massage);
    }
}
