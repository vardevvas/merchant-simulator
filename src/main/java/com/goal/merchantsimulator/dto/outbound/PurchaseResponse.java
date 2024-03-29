package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PurchaseResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

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
