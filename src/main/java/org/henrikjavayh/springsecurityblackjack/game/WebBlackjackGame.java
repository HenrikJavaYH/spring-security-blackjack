package org.henrikjavayh.springsecurityblackjack.game;


import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.henrikjavayh.springsecurityblackjack.core.game.GameLogic;
import org.henrikjavayh.springsecurityblackjack.core.model.Dealer;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;

public class WebBlackjackGame {

    private final GameLogic gameLogic;
    private boolean gameOver = false;
    private String result;

    public WebBlackjackGame() {
        CardProvider deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer(deck);

        this.gameLogic = new GameLogic(deck, player, dealer);
        this.gameLogic.initialDeal();

        if (player.hasBlackJack() || dealer.hasBlackJack()) {
            finishGame();
        }
    }

    public void hit() {
        if (gameOver) return;

        gameLogic.playerHits();

        if (gameLogic.getPlayer().isBusted()) {
            finishGame();
        }
    }

    public void stand() {
        if (gameOver) return;

        gameLogic.dealerTurn();
        finishGame();
    }

    private void finishGame() {
        this.gameOver = true;
        this.result = gameLogic.determineWinner();
    }

    public Player getPlayer() {
        return gameLogic.getPlayer();
    }

    public Dealer getDealer() {
        return gameLogic.getDealer();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getResult() {
        return result;
    }
}

