package org.henrikjavayh.springsecurityblackjack.gameresult;

import org.henrikjavayh.springsecurityblackjack.customuser.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameResultRepository
        extends JpaRepository<GameResult, Long> {

    List<GameResult> findByUser(CustomUser user);

    List<GameResult> findByUserOrderByPlayedAtDesc(CustomUser user);

    List<GameResult> findTop10ByUserOrderByPlayedAtDesc(CustomUser user);
}

