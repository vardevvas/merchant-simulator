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
    @NotNull(message = "Phone Number should not be empty or null")
    @Size(min = 12, max = 12)
    private String phoneNumber;

    @JsonProperty("voucherNumber")
    @NotNull(message = "Phone Number should not be empty or null")
    @Size(min = 12, max = 12)
    private Integer voucherNumber;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("checkDuplicate")
    @NotBlank(message = "check duplicate date is mandatory")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    @NotBlank(message = "transaction auth type date is mandatory")
    @Size(min = 2, max = 2, message = "fromAccountType size should be 2")
    @Pattern(regexp = "\\d+")
    private String tranAuthenticationType;

}
