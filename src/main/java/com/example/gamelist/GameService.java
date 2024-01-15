package com.example.gamelist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameMapper gameMapper;

    public GameService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
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

}
