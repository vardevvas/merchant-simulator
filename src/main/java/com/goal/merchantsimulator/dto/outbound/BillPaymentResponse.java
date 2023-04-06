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
public class BillPaymentResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("additionalAmount")
    private Double additionalAmount;

    @JsonProperty("additionalData")
    private String[] additionalData;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("payeeId")
    private String payeeId;

    @JsonProperty("billerResponseCode")
    private Integer billerResponseCode;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    private String tranAuthenticationType;

}
