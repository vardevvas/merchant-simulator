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
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "client_id", unique = true, nullable = false)
    private Long clientId;

    @Column(name = "systemtrace_audit_number", unique = true, nullable = false)
    private Long systemTraceAuditNumber;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;
}
