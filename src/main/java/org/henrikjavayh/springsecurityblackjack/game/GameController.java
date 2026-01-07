package org.henrikjavayh.springsecurityblackjack.game;

import org.henrikjavayh.springsecurityblackjack.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping
    public String game(Model model) {
        model.addAttribute("game", gameService.getGame());
        return "game";
    }


    @PostMapping("/start")
    public String startGame() {
        gameService.startNewGame();
        return "redirect:/game";
    }


    @PostMapping("/hit")
    public String hit() {
        gameService.hit();
        return "redirect:/game";
    }


    @PostMapping("/stand")
    public String stand() {
        gameService.stand();
        return "redirect:/game";
    }


    @PostMapping("/new")
    public String newGame() {
        gameService.startNewGame();
        return "redirect:/game";
    }
}
