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
public class GenerateVoucherResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("tranCurrencyCode")
    @NotBlank(message = "transaction Currency Code date is mandatory")
    @Size(max = 3)
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    @NotNull(message = "transaction amount should not be empty or null")
    private Double tranAmount;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("voucherNumber")
    private Integer voucherNumber;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    private String tranAuthenticationType;

}
