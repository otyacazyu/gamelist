package com.example.gamelist;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class GameController {


    private final GameMapper gameMapper;

    private final GameService gameService;

    @Autowired
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
        gameService.createGame(form.getName());
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

    @DeleteMapping("/gamelist/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>("Successfully deleted game list", HttpStatus.OK);
    }


    @ExceptionHandler(value = GameDuplicateException.class)
    public ResponseEntity<Map<String, String>> handGameNotFoundException(GameDuplicateException e, HttpServletRequest request) {

        Map<String, String> body = Map.of(
                "taimestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.CONFLICT.value()),
                "error", HttpStatus.CONFLICT.getReasonPhrase(),
                "message", e.getMessage(),
                "patch", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }
}
