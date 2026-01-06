package org.henrikjavayh.springsecurityblackjack.core.model;

import java.util.ArrayList;
import java.util.List;

import org.henrikjavayh.springsecurityblackjack.core.card.Card;

public class Player {

    private final List<Card> hand;

    public Player() {
        this.hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getHandValue() {
        int total = 0;
        int aces = 0;
        for (Card card : hand) {
            int value = card.getFaceValue();
            if (value == 11) {
                aces++;
            }
            total += value;
            while (total > 21 && aces > 0) {
                total -= 10;
                aces--;
            }
        }
        return total;
    }
    public boolean hasBlackJack () {
        return hand.size() == 2 && getHandValue() == 21;
    }
    public boolean isBusted () {
        return getHandValue() > 21;
    }

    @Override
    public String toString() {
        return  hand + " Value "+ getHandValue();
    }
}

