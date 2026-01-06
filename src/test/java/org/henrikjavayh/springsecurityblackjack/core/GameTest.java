package org.henrikjavayh.springsecurityblackjack.core;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;
import org.henrikjavayh.springsecurityblackjack.core.card.CardProvider;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class FakeDeck implements CardProvider {
    private final Queue<Card> cards = new LinkedList<>(List.of(
            new Card("Hearts", "Ace"),
            new Card("Hearts", "King")
    ));

    @Override
    public Card dealCard() {
        return cards.poll();
    }

    @Override
    public int remainingCards() {
        return cards.size();
    }
}

public class GameTest {

}
