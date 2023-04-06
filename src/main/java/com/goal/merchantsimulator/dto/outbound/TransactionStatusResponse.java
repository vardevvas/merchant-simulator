package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Map;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TransactionStatusResponse extends GeneralResponse {

    @JsonProperty("originalTranSystemTraceAuditNumber")
    private String originalTranSystemTraceAuditNumber;

    @JsonProperty(value = "originalTransaction")
    private Map<Object, Object> originalTransaction;

    @JsonProperty(value = "origionalTransactionType")
    private String origionalTransactionType;

}
