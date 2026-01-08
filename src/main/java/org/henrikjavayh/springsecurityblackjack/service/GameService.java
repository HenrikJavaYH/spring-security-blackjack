package org.henrikjavayh.springsecurityblackjack.service;

import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.henrikjavayh.springsecurityblackjack.customuser.CustomUserRepository;
import org.henrikjavayh.springsecurityblackjack.game.WebBlackjackGame;
import org.henrikjavayh.springsecurityblackjack.gameresult.GameResult;
import org.henrikjavayh.springsecurityblackjack.gameresult.GameResultRepository;
import org.henrikjavayh.springsecurityblackjack.gameresult.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameService {

    private final GameResultRepository gameResultRepository;
    private final CustomUserRepository customUserRepository;

    private WebBlackjackGame game;

    public GameService(GameResultRepository gameResultRepository, CustomUserRepository customUserRepository) {
        this.gameResultRepository = gameResultRepository;
        this.customUserRepository = customUserRepository;
    }

    public void startNewGame() {
        this.game = new WebBlackjackGame();
    }

    public void endGame() {
        this.game = null;
    }

    public boolean hasGame() {
        return game != null;
    }

    public WebBlackjackGame getGame() {
        return game;
    }

    public void hit() {
        game.hit();
    }

    public void stand() {
        game.stand();
    }

    public void finishGame(String username) {

        CustomUser user = customUserRepository
                .findByUsername(username)
                .orElseThrow();

        GameResult gameResult = new GameResult(
                user,
                resolveResult(game.getResult()),
                game.getPlayer().getHandValue(),
                game.getDealer().getHandValue()
        );

        gameResultRepository.save(gameResult);
    }

    private Result resolveResult(String outcome) {
        if (outcome.contains("Player Wins")) return Result.WIN;
        if (outcome.contains("Dealer Wins")) return Result.LOSS;
        return Result.DRAW;
    }


    public List<GameResult> getGameHistory(CustomUser user) {
        return gameResultRepository.findByUserOrderByPlayedAtDesc(user);
    }


}
