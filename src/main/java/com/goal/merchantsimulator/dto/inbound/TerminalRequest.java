package com.goal.merchantsimulator.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TerminalRequest {

    @JsonProperty("client_id")
    private Long clientId;

    @JsonProperty("systemTraceAuditNumber")
    private Long systemTraceAuditNumber;

    @JsonProperty("notes")
    private String notes;


}
