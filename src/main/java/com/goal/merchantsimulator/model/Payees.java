package com.goal.merchantsimulator.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Payees{

    @Column(name = "payee_name")
    private String payeeName;

    @Column(name = "payee_id")
    @Id
    private String payeeId;
}
