package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;
import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DeckTest {

    @Test
    public void testDeck() {
        Deck deck = new Deck();

        assertEquals(52, deck.remainingCards());
    }

    @Test
    public void testShuffle() {
        CardProvider deck = new Deck();
        Card card = deck.dealCard();

        assertNotEquals("Ace of Clubs", card.toString());
    }
}
