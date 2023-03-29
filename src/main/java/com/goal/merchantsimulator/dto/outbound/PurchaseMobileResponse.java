package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PurchaseMobileResponse extends GeneralResponse {

    @JsonProperty("mobileNo")
    private String mobileNo;

    @JsonProperty("tranCurrencyCode")
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    private Double tranAmount;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("additionalAmount")
    private Double additionalAmount;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    private String tranAuthenticationType;

}
