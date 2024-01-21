package com.example.gamelist;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

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

    @Select("SELECT * FROM gamelists WHERE name = #{name}")
    List<Game> findByName(String name);

    @Update("UPDATE gamelists SET name = #{name} WHERE id = #{id}")
    void save(Game game);
    @Delete("SELECT * FROM gamelist HWRE id = #{id}")
    void delete(Game game);

    @Transactional
    @Insert("INSERT INTO gamelists (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Game game);
}
