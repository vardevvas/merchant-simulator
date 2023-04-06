package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class VoucherCashInResponse extends GeneralResponse {

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("tranCurrencyCode")
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    private Double tranAmount;

    @JsonProperty("voucherNumber")
    private Integer voucherNumber;

    @JsonProperty("DisputeRRN")
    private Integer DisputeRRN;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("tranFee")
    private Double tranFee;

}
