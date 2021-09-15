package lab.football.controllers;

import lab.football.dao.PlayerDAO;
import lab.football.models.Club;
import lab.football.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/players")
public class PlayerController {
   private final PlayerDAO playerDAO;
   @Autowired
    public PlayerController(PlayerDAO playerDAO){
       this.playerDAO = playerDAO;
   }

    @GetMapping()
    private String index(Model model){
        model.addAttribute("players",playerDAO.index());
        return "players/index.html";
    }
    @GetMapping("/{id}")
    private String show(@PathVariable("id") int id,Model model){
        model.addAttribute("player",playerDAO.show(id));
        return "players/show.html";
    }
    @GetMapping("/{id}/new")
    private String createClub(@ModelAttribute("player") Player player){
        return "players/new.html";
    }

    @PostMapping("/{id}/new")
    private String create(@ModelAttribute("player") Player player, @PathVariable("id") int club_id){
       player.setClub_id(club_id);
        playerDAO.save(player);
        return "redirect:/players";
    }
    @GetMapping("/{id}/edit")
    private String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("player",playerDAO.show(id));
        return "players/edit.html";
    }
    @PatchMapping("/{id}/edit")
    private String update(@ModelAttribute("player") Player player,@PathVariable("id") int id){
        playerDAO.update(id,player);
        return "redirect:/players";
    }
    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") int id){
        playerDAO.delete(id);
        return "redirect:/players";
    }
}
