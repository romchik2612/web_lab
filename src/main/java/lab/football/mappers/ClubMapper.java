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

    public Club fromString(String str){
        Club club = new Club();
        str=str.substring(str.indexOf(":")+1);
        club.setName(str.substring(str.indexOf("\"")+1,str.indexOf(",")-1));
        str=str.substring(str.indexOf(":")+1);
        club.setYear_of_birth(Integer.parseInt(str.substring(str.indexOf("\"")+1,str.indexOf(",")-1)));
        str=str.substring(str.indexOf(":")+1);
        club.setPoints(Integer.parseInt(str.substring(str.indexOf("\"")+1,str.indexOf(",")-1)));
        str=str.substring(str.indexOf(":")+1);
        System.out.println(str);
        club.setLeague_id(Integer.parseInt(str.substring(str.indexOf("\"")+1,str.lastIndexOf("\""))));
        return club;
    }
}
