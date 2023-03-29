package com.goal.merchantsimulator.dto.outbound;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Data
@MappedSuperclass
public class GeneralResponse {

    @JsonProperty("clientId")
    private Long clientId;

    @JsonProperty("terminalId")
    private Long terminalId;

    @JsonProperty("tranDateTime")
    private Date tranDateTime;

    @JsonProperty("systemTraceAuditNumber")
    private Long systemTraceAuditNumber;

    @JsonProperty(value = "responseCode")
    private int responseCode;

    @JsonProperty(value = "responseMessage")
    private String responseMessage;

    @JsonProperty(value = "responseStatus")
    private String responseStatus;


}

