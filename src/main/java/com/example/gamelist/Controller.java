package com.example.gamelist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/controller")
public class Controller {

    private final GameMapper gameMapper;

    public Controller (GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    @GetMapping("/gamelist")
    public  List<GameName> gamelist(){
        return gameMapper.findAll();
    }


    @PostMapping("/gamelist")
    public ResponseEntity<String> create(@RequestBody GameFrom form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/gamelist/id")
                .build()
                .toUri();
        return ResponseEntity.ok("name successfully created");
    }
}
