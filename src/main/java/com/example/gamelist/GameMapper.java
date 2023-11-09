package com.example.gamelist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.naming.Name;
import java.util.List;

@Mapper
public interface GameMapper {

    @Select("SELECT * FROM game lists")
    List<GameName> findAll();
}
