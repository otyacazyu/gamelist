package com.example.gamelist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GameMapper {

    @Select("SELECT * FROM gamelists")
    List<GameName> findAll();
}
