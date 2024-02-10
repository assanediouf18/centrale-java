package org.centrale.api;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Shifumi")
public class ShifumiEntity {
    @Id
    private Integer id;

    private String player1, player2;
    private int score1, score2;
    private String hand1, hand2;

    public ShifumiEntity()
    {
        player1 = player2 = "";
        hand1 = hand2 = "";
        score1 = score2 = 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public String getHand2() {
        return hand2;
    }

    public void setHand2(String hand2) {
        this.hand2 = hand2;
    }

    public String getHand1() {
        return hand1;
    }

    public void setHand1(String hand1) {
        this.hand1 = hand1;
    }
}
