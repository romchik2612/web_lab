package lab.football.mappers;

import lab.football.dao.ClubDAO;
import lab.football.models.Club;
import lab.football.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class PlayerMapper implements RowMapper<Player> {

    @Override
    public Player mapRow(ResultSet resultSet, int i) throws SQLException {
        Player player = new Player();
        player.setId(resultSet.getInt("id"));
        player.setName(resultSet.getString("name"));
        player.setSourname(resultSet.getString("sourname"));
        player.setNumber(resultSet.getInt("number"));
        player.setMark(resultSet.getDouble("mark"));
        player.setClub_id(resultSet.getInt("club_id"));

        return player;
    }
}
