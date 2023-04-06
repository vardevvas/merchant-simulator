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

    @Id
    @Column(name = "payee_id")
    private String payeeId;

    @Column(name = "payee_name")
    private String payeeName;

}
