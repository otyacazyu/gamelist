package com.example.gamelist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final GameMapper gameMapper;

    public Controller (GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    @GetMapping("/gamelist")
    public  List<GameName> gamelist(){
        List<GameName> gamelists = gameMapper.findAll();
                return gamelists;
    }
}
