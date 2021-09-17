package lab.football.dao;

import lab.football.mappers.ClubMapper;
import lab.football.models.Club;
import lab.football.models.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClubDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClubDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Club> index(){
        return jdbcTemplate.query("SELECT * FROM Club ORDER BY points DESC", new ClubMapper());
    }

    public List<Club> showLeague(int league_id){
        return jdbcTemplate.query("SELECT * FROM Club WHERE league_id=? ORDER BY points DESC", new Object[]{league_id}, new ClubMapper());
    }

    public Club show(int id){
        return  jdbcTemplate.query("SELECT * FROM Club WHERE id=?", new Object[]{id},new ClubMapper()).stream().findAny().orElse(null);
    }

    public void save(Club club){
        jdbcTemplate.update("INSERT  INTO Club VALUES(?,?,?,?,?) ", club.hashCode(),club.getName(),club.getYear_of_birth(),club.getPoints(), club.getLeague_id());
    }

    public void update(int id, Club updateClub){
        jdbcTemplate.update("UPDATE Club SET name=?,year_of_birth=?,points=? WHERE id=?",updateClub.getName(),updateClub.getYear_of_birth(),updateClub.getPoints(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Club WHERE id=?", id);
    }
}
