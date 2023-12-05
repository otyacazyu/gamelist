package com.example.gamelist;

import org.springframework.stereotype.Service;

@Service
public class gamelistService {

    private final GameMapper gameMapper;

    public gamelistService(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    public <Gamelist> void update(int id, String name) {
        gameMapper.findById(id)
                .orElseThrow(() -> new GameNotFoundException("gamelist information not found"));
        boolean isName = this.gameMapper.findByNameExceptId(name,Id).isGamelist();
        if(isName){
            throw new ArithmeticException("Already registered data");
        }
        Gamelist gamelist = new Gamelist(id,name);
        gameMapper.update(gamelist);
    }
}
