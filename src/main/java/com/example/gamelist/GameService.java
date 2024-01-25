package com.example.gamelist;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private final GameMapper gameMapper;

    public GameService(GameMapper gameMapper) {

        this.gameMapper = gameMapper;
    }

    public void createGame(String name) {
        List<Game> existingGames = gameMapper.findByName(name);
        if (existingGames.isEmpty()) {
            Game newGame = new Game(generateUniqueId(), name);
            gameMapper.save(newGame);
        } else {
            throw new GameDuplicateException("Already registered data");
        }
    }

    private int generateUniqueId() {
        return new Random().nextInt(1000);
    }

    public void updateGame(final Integer id, String name) {
        Game game = gameMapper.findById(id).orElseThrow(() -> new GameNotFoundException("game information not found"));
        List<Game> otherGames = this.gameMapper.findByName(name);

        if (otherGames.stream().noneMatch(g -> g.getName().equals(name))) {
            game.setName(name);
            gameMapper.save(game);
        } else {
            throw new GameDuplicateException("Already registered data");
        }
    }

    public void deleteGame(Integer id) {
        Game game = gameMapper.findById(id).orElseThrow(() -> new GameNotFoundException("The game of conditions does not exist."));
        gameMapper.delete(game);
    }
}