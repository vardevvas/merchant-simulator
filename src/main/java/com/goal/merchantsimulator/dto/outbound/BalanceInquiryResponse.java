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
public class BalanceInquiryResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("additionalAmount")
    private Double additionalAmount;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("tranAuthenticationType")
    private String tranAuthenticationType;

}
