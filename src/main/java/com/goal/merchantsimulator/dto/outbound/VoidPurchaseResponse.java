package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VoidPurchaseResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("originalTranSystemTraceAuditNumber")
    private String originalTranSystemTraceAuditNumber;

    @JsonProperty("originalTranReferenceNumber")
    private Long originalTranReferenceNumber;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

}
