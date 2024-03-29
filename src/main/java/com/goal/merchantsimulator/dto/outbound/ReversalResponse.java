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
public class ReversalResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("serviceId")
    private String serviceId;

    @JsonProperty("originalTranSystemTraceAuditNumber")
    private String originalTranSystemTraceAuditNumber;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

}
