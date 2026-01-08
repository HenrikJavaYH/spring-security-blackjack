package org.henrikjavayh.springsecurityblackjack.gameresult;


import jakarta.persistence.*;
import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;

import java.time.LocalDateTime;

@Entity
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private CustomUser user;

    @Enumerated(EnumType.STRING)
    private Result result;

    private int playerScore;
    private int dealerScore;

    private LocalDateTime playedAt;

    protected GameResult() {

    }

    public GameResult(CustomUser user,
                      Result result,
                      int playerScore,
                      int dealerScore) {

        this.user = user;
        this.result = result;
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        this.playedAt = LocalDateTime.now();
    }


    public Result getResult() {
        return result;
    }

    public CustomUser getUser() {
        return user;
    }
}

