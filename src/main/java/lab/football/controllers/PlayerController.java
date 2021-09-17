package lab.football.controllers;

import lab.football.dao.ClubDAO;
import lab.football.dao.PlayerDAO;
import lab.football.models.Club;
import lab.football.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/players")
public class PlayerController {
   private final PlayerDAO playerDAO;
   private  final ClubDAO clubDAO;
   @Autowired
    public PlayerController(PlayerDAO playerDAO, ClubDAO clubDAO){
       this.playerDAO = playerDAO;
       this.clubDAO = clubDAO;
   }

    @GetMapping()
    private String index(Model model){
        model.addAttribute("players",playerDAO.index());
        return "players/index.html";
    }
    @GetMapping("/{id}")
    private String show(@PathVariable("id") int id,Model model){
        model.addAttribute("player",playerDAO.show(id));
        model.addAttribute("club",clubDAO.show(playerDAO.show(id).getClub_id()));
        return "players/show.html";
    }
    @GetMapping("/{id}/new")
    private String createClub(@ModelAttribute("player") Player player){
        return "players/new.html";
    }

    @PostMapping("/{id}/new")
    private String create(@ModelAttribute("player") @Valid Player player,BindingResult bindingResult, @PathVariable("id") int club_id){
       if(bindingResult.hasErrors()) return "players/new.html";
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
    private String update(@ModelAttribute("player") @Valid Player player,BindingResult bindingResult,@PathVariable("id") int id){
       if(bindingResult.hasErrors()) return "players/edit.html";
        playerDAO.update(id,player);
        return "redirect:/players";
    }
    @DeleteMapping("/{id}")
    private String delete(@PathVariable("id") int id){
        playerDAO.delete(id);
        return "redirect:/players";
    }
}
