package lab.football.restControllers;

import lab.football.dao.PlayerDAO;
import lab.football.mappers.ClubMapper;
import lab.football.mappers.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerRestController {
    private final PlayerDAO playerDAO;
    @Autowired
    public PlayerRestController(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    private String getPLayers(){
        return playerDAO.index().toString();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    private String getPlayer(@PathVariable int id){
        return playerDAO.show(id).toString();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    private void setPlayer(@RequestBody String str){
        playerDAO.save(new PlayerMapper().fromString(str));
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void updatePLayer(@RequestBody String str,@PathVariable int id){
        playerDAO.update(id,new PlayerMapper().fromString(str));
    }
    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void deletePlayer(@PathVariable int id){
        playerDAO.delete(id);
    }
}
