package org.henrikjavayh.springsecurityblackjack.core.game;

import org.henrikjavayh.springsecurityblackjack.core.model.Dealer;
import org.henrikjavayh.springsecurityblackjack.core.model.Player;

public class GameUI {

    private final InputProvider input;
    private final GameLogic logic;

    public GameUI(InputProvider input, GameLogic logic) {
        this.input = input;
        this.logic = logic;
    }

    public void start() {
        printRules();
        logic.initialDeal();
        Player player = logic.getPlayer();
        Dealer dealer = logic.getDealer();

        System.out.println("Dealer's card: " + dealer.showFirstCard());

        while (!player.hasBlackJack() && !player.isBusted()) {
            System.out.println("Your hand: " + player);
            System.out.println("Hit or stand? ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("hit")) {
                logic.playerHits();
                System.out.println("You got: " + player.getHand().getLast());
            } else if (choice.equals("stand")) {
                System.out.println("You have chosen to stand" + "\n");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        if (!player.isBusted()) {
            System.out.println("The dealer shows both cards");
            System.out.println("Dealer's cards: " + dealer + "\n");
            while (dealer.shouldHit()) {
                dealerTurnDelay();
            }
        }
        displayResults();
    }

    public void dealerTurnDelay() {
        try {
            Thread.sleep(1000);
            logic.dealerTurn();
            System.out.println("Dealer got: " + logic.getDealer().getHand().getLast());
            System.out.println("Dealer's cards: " + logic.getDealer());
            System.out.println();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRules() {
        System.out.println("""
                Welcome to the Blackjack Game.
                On start, you will be dealt 2 cards,
                Jack, Queen and Kings are worth 10,
                Aces are worth either 1 or 11, depending on if the ace takes you above 21 score,
                You must hit or stand; Try to get as close as possible to 21 to win.
                When the player stands, the dealer will play.
                """);
    }

    public void displayResults() {
        System.out.println("-------------------------");
        System.out.println("Game over");
        System.out.println("Final hands:");
        System.out.println("Player: " + logic.getPlayer());
        System.out.println("Dealer: " + logic.getDealer());
        System.out.println(logic.determineWinner());
        System.out.println("-------------------------");
    }
}
