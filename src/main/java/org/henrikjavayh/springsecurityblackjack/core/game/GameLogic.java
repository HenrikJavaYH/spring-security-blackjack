package org.henrikjavayh.springsecurityblackjack.core.game;

import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.model.Dealer;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;

public class GameLogic {


    private final CardProvider deck;
    private final Player player;
    private final Dealer dealer;

    public GameLogic(CardProvider deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    public void initialDeal() {
        dealer.dealToPlayer(player);
        dealer.dealToPlayer(player);

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    public void playerHits() {
        dealer.dealToPlayer(player);
    }

    public void dealerTurn() {
        dealer.dealToDealer();
    }

    public String determineWinner() {
        if (player.isBusted() || dealer.hasBlackJack()) {
            return ("Dealer Wins!");
        } else if (player.hasBlackJack() || dealer.isBusted()) {
            return ("Player Wins!");
        } else if (dealer.getHandValue() < player.getHandValue()) {
            return ("Player Wins");
        } else if (dealer.getHandValue() > player.getHandValue()) {
            return ("Dealer Wins");
        } else {
            return ("Its a tie!");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }
}

