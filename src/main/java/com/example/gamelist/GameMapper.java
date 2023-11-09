package com.example.gamelist;

import org.apache.ibatis.annotations.Select;

import javax.naming.Name;
import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface GameMapper {

    @Select("SELECT * FROM game lists")
    List<Name> findAll();
}
