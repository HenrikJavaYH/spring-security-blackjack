package org.henrikjavayh.springsecurityblackjack.core.card;

public interface CardProvider {
    Card dealCard();
    int remainingCards();
}
