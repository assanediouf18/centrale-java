package org.centrale.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Shifumi")
public class ShifumiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private PlayerEntity winner;

    @ManyToOne
    @JoinColumn(name = "loser_id")
    private PlayerEntity loser;
    boolean equal = false;

    public PlayerEntity getWinner() {
        return winner;
    }

    public void setWinner(PlayerEntity winner) {
        this.winner = winner;
    }

    public PlayerEntity getLoser() {
        return loser;
    }

    public void setLoser(PlayerEntity loser) {
        this.loser = loser;
    }

    public boolean isEqual() {
        return equal;
    }

    public void setEqual(boolean equal) {
        this.equal = equal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
