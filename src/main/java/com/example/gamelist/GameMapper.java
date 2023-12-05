package com.example.gamelist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface GameMapper {

    @Select("SELECT * FROM gamelists")
    List<Game> findAll();

    Optional<Object> findById(int id);
}
