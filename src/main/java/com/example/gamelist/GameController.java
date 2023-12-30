package com.example.gamelist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class GameController {


    private final GameMapper gameMapper;

    private final GameService gameService;

    public GameController(GameMapper gameMapper, GameService gameService) {
        this.gameMapper = gameMapper;
        this.gameService = gameService;
    }

    @GetMapping("/gamelist")
    public  List<Game> gamelist(){
        return gameMapper.findAll();
    }
    
    @PostMapping("/gamelist")
    public ResponseEntity<Response> create(@RequestBody GameForm form){
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/gamelist/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(new Response("game successfully created"));
    }

    @PatchMapping("/gamelist/{id}")
    public ResponseEntity<UpdateResponse> UpdateGame(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        gameService.updateGame(id, updateRequest.getName());
        UpdateResponse updataResponse = new UpdateResponse("Contents have been updated!");
        return ResponseEntity.ok(updataResponse);

    }
}
