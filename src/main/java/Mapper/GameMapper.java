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

    @Select("SELECT * FROM gamelists")
    List<Game> findAll();

    Optional<Object> findById(int id);

    Object findByNameExceptId(String name, int id);

    @Update(UPDATE gamelist SET name = WHERE ID = #{id})
    void updateGamelist(Gamelist gamelist);
}
