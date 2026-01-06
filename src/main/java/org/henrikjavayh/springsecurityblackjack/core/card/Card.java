package org.henrikjavayh.springsecurityblackjack.core.card;

public class Card {
    private final String cardSuit;
    private final String cardValue;

    public Card(String cardSuit, String cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return cardValue + " of " + cardSuit;
    }

    public int getFaceValue() {
        return switch (cardValue) {
            case "Jack", "Queen", "King" -> 10;
            case "Ace" -> 11;
            default -> Integer.parseInt(cardValue);
        };
    }
}



