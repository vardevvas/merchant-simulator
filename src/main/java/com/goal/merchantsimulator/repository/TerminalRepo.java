package com.goal.merchantsimulator.repository;

import com.goal.merchantsimulator.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TerminalRepo extends JpaRepository<Terminal, Long> {

    Optional<Terminal> findByClientId(Long clientId);
}
