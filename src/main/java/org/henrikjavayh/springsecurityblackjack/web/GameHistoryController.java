package org.henrikjavayh.springsecurityblackjack.web;


import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.henrikjavayh.springsecurityblackjack.service.GameService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameHistoryController {

    private final GameService gameService;

    public GameHistoryController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public String gameHistory(
            @AuthenticationPrincipal CustomUser user,
            Model model
    ) {
        model.addAttribute("games",
                gameService.getGameHistory(user));

        return "games";
    }
}
