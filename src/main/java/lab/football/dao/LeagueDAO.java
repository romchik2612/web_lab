package lab.football.dao;

import lab.football.mappers.LeagueMapper;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeagueDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LeagueDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<League> index(){
        return jdbcTemplate.query("SELECT * FROM League ORDER BY prizefond DESC", new LeagueMapper());
    }

    public League show(int id){
        return jdbcTemplate.query("SELECT * FROM League WHERE id =?", new Object[]{id},new LeagueMapper()).stream().findAny().orElse(null);
    }

    public void save(League league){
        jdbcTemplate.update("INSERT  INTO League VALUES(?,?,?) ", league.hashCode(),league.getName(),league.getPrizefond() );
    }

    public void updateId( int id, String name){
        jdbcTemplate.update("UPDATE League SET id=? WHERE name=?", id,name);
    }

    public void update(int id, League updateLeague){
        jdbcTemplate.update("UPDATE League SET name=?,prizefond=? WHERE id=?",updateLeague.getName(),updateLeague.getPrizefond(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM League WHERE id=?", id);
    }
}
