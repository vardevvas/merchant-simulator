package com.goal.merchantsimulator.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TransactionStatusRequest extends DefaultRequest{

    @JsonProperty("originalTranSystemTraceAuditNumber")
    @NotBlank(message = "Original transaction system trace audit number is mandatory")
    private String originalTranSystemTraceAuditNumber;

}
