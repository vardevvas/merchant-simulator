package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CashOutVoucherResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("tranCurrencyCode")
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    private Double tranAmount;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("voucherNumber")
    private Integer voucherNumber;

    @JsonProperty("approvalCode")
    private String approvalCode;

}
