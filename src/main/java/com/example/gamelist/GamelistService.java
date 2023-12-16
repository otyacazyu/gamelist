package com.example.gamelist;

import Mapper.GameMapper;
import org.springframework.stereotype.Service;

import static com.example.gamelist.GamelistService.UpdateRequest.name;

@Service
public class GamelistService {

    private final GameMapper gameMapper;

    public GamelistService(GameMapper gameMapper) {

        this.gameMapper = gameMapper;
    }

    public <Gamelist> updateGamelist(final Integer id) {
        Gamelist gamelist = gameMapper.findById(id)
                .orElseThrow(() -> new GameNotFoundException("gamelist information not found"));
        boolean isName = this.gameMapper.findByNameExceptId(name, id).isGamelist();
        if (UpdateRequest.getName() != null) {
            gamelist.setName(UpdateRequest.getName());
            throw new ArithmeticException("Already registered data");
        }
    }


}
