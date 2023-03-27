package com.goal.merchantsimulator.repository;

import com.goal.consumersimulator.model.Payees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayeesRepo extends JpaRepository<Payees, Long> {
}
