package lab.football.mappers;

import lab.football.dao.ClubDAO;
import lab.football.models.Club;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;

@Component
public class LeagueMapper implements RowMapper<League> {
    @Override
    public League mapRow(ResultSet resultSet, int i) throws SQLException {
        League league = new League();
        league.setId(resultSet.getInt("id"));
        league.setName(resultSet.getString("name"));
        league.setPrizefond(resultSet.getInt("prizefond"));


        return league;
    }
}
