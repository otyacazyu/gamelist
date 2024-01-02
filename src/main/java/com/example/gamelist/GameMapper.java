package com.example.gamelist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;


@Mapper
public interface GameMapper {

    //データを一括で取得する。　GET
    @Select("SELECT * FROM gamelists")
    List<Game> findAll();

    @Select("SELECT * FROM gamelists WHERE id = #{id}")
    Optional<Game> findById(int id);

    @Update("UPDATE gamelists SET name = {#name} WHERE id = #{id}")
    void update(Game game);

    @Update("UPDATE gamelists SET name = :name WHERE id = :id")
    List<Game> findByName(String name);
}
