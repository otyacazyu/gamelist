package com.example.gamelist;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.gamelist.GamelistService.UpdateRequest.name;

@Service
public class GamelistService {

    private final GameMapper gameMapper;

    public GamelistService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

     public Game updateGame(final Integer id,String name) {
        Game game = gameMapper.findById(id)
                .orElseThrow(() -> new GameNotFoundException("gamelist information not found"));
        List<Game> otherGames = this.gameMapper.findByName(name);

        if (otherGames.stream().anyMatch(game -> game.getName().equals(name))) {
            game.setName(UpdateRequest.getName());
            throw new ArithmeticException("Already registered data");
        }
    }
}



}
