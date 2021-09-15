package lab.football.mappers;

import lab.football.dao.LeagueDAO;
import lab.football.dao.PlayerDAO;
import lab.football.models.Club;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class ClubMapper implements RowMapper<Club> {


    @Override
    public Club mapRow(ResultSet resultSet, int i) throws SQLException {
        Club club = new Club();
        club.setId(resultSet.getInt("id"));
        club.setName(resultSet.getString("name"));
        club.setYear_of_birth(resultSet.getInt("year_of_birth"));
        club.setPoints(resultSet.getInt("points"));
        club.setLeague_id(resultSet.getInt("league_id"));

        return club;
    }
}
