package com.example.gamelist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class GameController {

    private final GameMapper gameMapper;

    public GameController(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    @GetMapping("/gamelist")
    public  List<Game> gamelist(){
        return gameMapper.findAll();
    }



    @PostMapping("/gamelist")
    public ResponseEntity<GamelistService.Response> create(@RequestBody GameForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/gamelist/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(new GamelistService.Response("name successfully created"));
    }



    @PatchMapping("/gamelist/{id}")
    public ResponseEntity<UpdateResponse> UpdateGamelist(@PathVariable int id, @RequestBody GamelistService.UpdateRequest updateRequest){
        Gamelists.update(id,updateRequest.getName());
         UpdateResponse updataResponse = new UpdateResponse("Contents have been updated!");
         return ResponseEntity.ok(updataResponse);

    }
}
