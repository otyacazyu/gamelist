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

    public <Gamelist> updateGamelist(final Integer id,String name) {
        Gamelist gamelist = gameMapper.findById(id)
                .orElseThrow(() -> new GameNotFoundException("gamelist information not found"));
        List<Gamelist> otherGamelist = this.gameMapper.findByName(name);

        if (otherGamelist.stream().anyMatch(gamelist -> gamelist.getName().equals(getName)) {
            gamelist.setName(UpdateRequest.getName());
            throw new ArithmeticException("Already registered data");
        }
    }



}
