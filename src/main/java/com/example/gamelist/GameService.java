package com.example.gamelist;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameMapper gameMapper;

    public GameService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    public Game updateGame(final Integer id, String name) {
        Game game = gameMapper.findById(id)
                .orElseThrow(() -> new GameNotFoundException("gamelist information not found"));
        List<Game> otherGames = this.gameMapper.findByName(name);
//
        if (otherGames.stream().anyMatch(game -> game.getName().equals(name))) {
            game.setName(UpdateRequest.getName());
            if (isGameAlreadyRegistered(UpdateRequest.getName())) {
            throw new DuplicateKeyException("Already registered data");
        }
// 戻す物があるか？？
    }

