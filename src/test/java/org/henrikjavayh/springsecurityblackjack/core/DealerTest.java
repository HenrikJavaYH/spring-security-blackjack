package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;
import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.henrikjavayh.springsecurityblackjack.core.model.Dealer;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Player player;
    private CardProvider deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
        dealer = new Dealer(deck);
        player = new Player();
    }

    @Test
    void DealerDealCardsTest () {
        dealer.dealToPlayer(player);

        assertEquals(1, player.getHand().size());
        assertEquals(51, deck.remainingCards());
    }

    @Test
    void DealToDealerTest () {
        dealer.dealToDealer();

        assertTrue(dealer.getHandValue() >= 17);
    }

    @Test
    void shouldHitTest () {
        dealer.addCard(new Card("Spades", "Queen"));
        dealer.addCard(new Card("Hearts", "7"));

        assertFalse(dealer.shouldHit());
    }

    @Test
    void showFirstCardTest() {
        dealer.addCard(new Card("Spades", "8"));
        dealer.addCard(new Card("Hearts", "7"));

        assertEquals(15, dealer.getHandValue());
        assertEquals(8, dealer.showFirstCard().getFaceValue());
    }
}

