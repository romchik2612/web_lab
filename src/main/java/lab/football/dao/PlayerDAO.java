package lab.football.dao;

import lab.football.mappers.PlayerMapper;
import lab.football.models.Club;
import lab.football.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PlayerDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> index(){
        return jdbcTemplate.query("SELECT * FROM Player ORDER BY mark DESC", new PlayerMapper());
    }

    public List<Player> showClub(int club_id){
        return jdbcTemplate.query("SELECT * FROM Player WHERE club_id=? ORDER BY mark DESC", new Object[]{club_id}, new PlayerMapper());
    }

    public Player show(int id){
        return  jdbcTemplate.query("SELECT FROM Player WHERE id=?", new Object[]{id},new PlayerMapper()).stream().findAny().orElse(null);
    }

    public void save(Player player){
        jdbcTemplate.update("INSERT  INTO Player VALUES(?,?,?,?,?,?) ", player.hashCode(),player.getName(),player.getSourname(),player.getNumber(),player.getMark(),player.getClub_id());
    }

    public void update(int id, Player updatePlayer){
        jdbcTemplate.update("UPDATE Player SET name=?,sourname=?,number=?,mark=? WHERE id=?",updatePlayer.getName(),updatePlayer.getSourname(),updatePlayer.getNumber(),updatePlayer.getMark(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Player WHERE id=?", id);
    }
}
