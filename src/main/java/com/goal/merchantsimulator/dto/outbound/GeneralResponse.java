package com.goal.merchantsimulator.dto.outbound;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class GeneralResponse {

    @JsonProperty(value = "terminalId")
    private String terminalId;

    @JsonProperty(value = "tranDateTime")
    private String tranDateTime;

    @JsonProperty(value = "responseCode")
    private int responseCode;

    @JsonProperty(value = "responseMessage")
    private String responseMessage;

    @JsonProperty(value = "responseStatus")
    private String responseStatus;


}

