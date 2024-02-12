package org.centrale.api.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.centrale.api.entity.PlayerEntity;
import org.centrale.api.entity.ShifumiEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShifumiEntityManager {
    private final EntityManager manager;

    public ShifumiEntityManager(EntityManager entityManager) {
        this.manager = entityManager;
    }

    public int getWinCount(PlayerEntity player)
    {
        TypedQuery<ShifumiEntity> query = manager.createQuery(
                "SELECT s FROM ShifumiEntity s WHERE s.winner = :player and s.equal = false ",
                ShifumiEntity.class);
        return query.setParameter("player", player).getResultList().size();
    }

    public int getLoseCount(PlayerEntity player)
    {
        TypedQuery<ShifumiEntity> query = manager.createQuery(
                "SELECT s FROM ShifumiEntity s WHERE s.loser = :player and s.equal = false ",
                ShifumiEntity.class);
        return query.setParameter("player", player).getResultList().size();
    }

    public List<PlayerEntity> getWorstEnnemy(PlayerEntity player)
    {
        TypedQuery<PlayerEntity> query = manager.createQuery(
                "SELECT s.winner FROM ShifumiEntity s " +
                        "WHERE s.loser = :player and s.equal = false " +
                        "GROUP BY s.winner order by COUNT(s.winner) ",
                PlayerEntity.class).setMaxResults(1);
        return query.setParameter("player", player).getResultList();
    }
}
