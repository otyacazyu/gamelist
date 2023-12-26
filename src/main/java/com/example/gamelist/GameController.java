package com.example.gamelist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.created(url).body(new Response("gamelist successfully created"));
    }



    @PatchMapping("/gamelist/{id}")
    public ResponseEntity<UpdateResponse> UpdateGame(@PathVariable int id, @RequestBody UpdateRequest updateRequest) {
        gameService.updateRequest(id, updateRequest.getName());
         UpdateResponse updataResponse = new UpdateResponse("Contents have been updated!");
         return ResponseEntity.ok(updataResponse);

    }
}
