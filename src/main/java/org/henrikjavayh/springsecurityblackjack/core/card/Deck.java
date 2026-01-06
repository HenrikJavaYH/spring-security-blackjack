package org.henrikjavayh.springsecurityblackjack.core.card;

import java.util.*;

public class Deck implements CardProvider {
    private final Deque<Card> cards;
    private static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Deck() {
        this.cards = new ArrayDeque<>();
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
        shuffle();
    }

    private void shuffle() {
        List<Card> shuffled = new ArrayList<>(cards);
        Collections.shuffle(shuffled);
        cards.clear();
        cards.addAll(shuffled);
    }

    @Override
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.pollFirst();
    }

    @Override
    public int remainingCards() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

