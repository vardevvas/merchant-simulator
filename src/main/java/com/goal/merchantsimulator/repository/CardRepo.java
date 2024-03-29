package com.goal.merchantsimulator.repository;

import com.goal.merchantsimulator.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {


    Optional<Card> findByPan(String pan);
}
