package org.henrikjavayh.springsecurityblackjack.service;

import org.henrikjavayh.springsecurityblackjack.game.WebBlackjackGame;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameService {

    private WebBlackjackGame game;

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
}
