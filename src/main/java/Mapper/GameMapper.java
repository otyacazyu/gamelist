package Mapper;

import com.example.gamelist.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

import static java.awt.event.PaintEvent.UPDATE;
import static javax.swing.text.html.parser.DTDConstants.ID;

@Mapper
public interface GameMapper {

    //データを一括で取得する。　GET
    @Select("SELECT * FROM gamelists")
    List<Game> findAll();

    @Select("SELECT * FROM gamelists WHERE id = #{id}")
    Optional<Game> findById(int id);

    @Update(UPDATE gamelist SET name = {#name} WHERE id = #{id})
    void updateGamelist(Gamelist gamelist);
}
