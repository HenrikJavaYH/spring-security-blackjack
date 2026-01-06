package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    @Test
    void addCardTest() {
        Deck deck = new Deck();
        Player player = new Player();
        player.addCard(deck.dealCard());

        assertEquals(1, player.getHand().size());
    }

    @Test
    void handValueTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));

        assertEquals(20, player.getHandValue());
    }

    @Test
    void handAceValueTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));
        player.addCard(new Card("Diamonds", "Ace"));

        assertEquals(21, player.getHandValue());
    }

    @Test
    void isBustedTest() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Queen"));
        player.addCard(new Card("Diamonds", "King"));

        assertTrue(player.isBusted());
    }

    @Test
    void hasBlackJack() {
        Player player = new Player();
        player.addCard(new Card("Spades", "Jack"));
        player.addCard(new Card("Clubs", "Ace"));

        assertTrue(player.hasBlackJack());
    }
}

