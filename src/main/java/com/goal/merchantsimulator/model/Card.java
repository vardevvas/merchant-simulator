package com.goal.merchantsimulator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PAN",nullable = false,unique = true)
    private String pan;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "exp_date")
    private String expDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bank")
    private String bank;

    @Column(name = "branch")
    private String branch;

    @Column(name = "name")
    private String name;

    @Column(name = "mbr")
    private String mbr;

    @Column(name = "status")
    private String status;

    @Column(name = "ipin")
    private String ipin;
}
