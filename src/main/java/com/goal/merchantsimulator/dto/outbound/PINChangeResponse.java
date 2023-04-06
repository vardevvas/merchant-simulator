package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PINChangeResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("approvalCode")
    private String approvalCode;

}
