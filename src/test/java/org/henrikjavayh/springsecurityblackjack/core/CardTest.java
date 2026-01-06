package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;
import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;
import org.henrikjavayh.springsecurityblackjack.core.card.Deck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @Test
    void testDealCard() {
        Deck deck = new Deck();
        deck.dealCard();
        assertEquals(51, deck.remainingCards());
    }

    @Test
    void cardFaceValueTest() {
        Card Jack = new Card("Spades", "Jack");
        Card Queen = new Card("Clubs", "Queen");
        Card King = new Card("Diamonds", "King");

        assertEquals(10, Jack.getFaceValue());
        assertEquals(10, Queen.getFaceValue());
        assertEquals(10, King.getFaceValue());
    }

    @Test
    void cardAceValueTest() {
        Card Ace = new Card("Spades", "Ace");

        assertEquals(11, Ace.getFaceValue());
    }
}

