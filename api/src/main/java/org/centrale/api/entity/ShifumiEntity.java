package org.centrale.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Shifumi")
public class ShifumiEntity {
    @Id
    private Integer id;

    @ManyToOne
    private PlayerEntity winner, loser;
    boolean equal = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
