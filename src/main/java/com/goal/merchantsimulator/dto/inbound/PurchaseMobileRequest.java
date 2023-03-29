package com.goal.merchantsimulator.dto.inbound;

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
public class PurchaseMobileRequest extends DefaultRequest {

    @JsonProperty("mobileNo")
    @NotNull(message = "PIN should not be empty or null")
    @Size(min = 12, max = 12)
    private String mobileNo;

    @JsonProperty("pin")
    @NotNull(message = "PIN should not be empty or null")
    @Size(min = 16, max = 16)
    private String pin;

    @JsonProperty("tranCurrencyCode")
    @NotBlank(message = "transaction Currency Code date is mandatory")
    @Size(max = 3)
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    @NotNull(message = "transaction amount should not be empty or null")
    private Double tranAmount;

    @JsonProperty("checkDuplicate")
    @NotBlank(message = "check duplicate date is mandatory")
    private Boolean checkDuplicate;

}
