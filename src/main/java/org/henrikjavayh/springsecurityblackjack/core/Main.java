package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.henrikjavayh.springsecurityblackjack.core.game.GameLogic;
import org.henrikjavayh.springsecurityblackjack.core.game.GameUI;
import org.henrikjavayh.springsecurityblackjack.core.game.InputProvider;
import org.henrikjavayh.springsecurityblackjack.core.game.TerminalInputProvider;
import org.henrikjavayh.springsecurityblackjack.core.model.Dealer;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;

public class Main {
    public static void main(String[] args) {
        CardProvider deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer(deck);

        GameLogic logic = new GameLogic(deck, player, dealer);
        InputProvider input = new TerminalInputProvider();

        GameUI game = new GameUI(input, logic);
        game.start();
    }
}