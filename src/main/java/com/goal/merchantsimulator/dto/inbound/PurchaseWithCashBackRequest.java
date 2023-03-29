package com.goal.merchantsimulator.dto.inbound;

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
public class PurchaseWithCashBackRequest extends DefaultRequest {

    @JsonProperty("pan")
    @Pattern(regexp = "^(?=[0-9]*$)(?:.{16}|.{19})$", message = "PAN must be either 16 or 19 numbers")
    @NotBlank(message = "pan is mandatory")
    private String pan;

    @JsonProperty("pin")
    @NotNull(message = "PIN should not be empty or null")
    @Size(min = 16, max = 16)
    private String pin;

    @JsonProperty("expiry_date")
    @NotBlank(message = "expiry date is mandatory")
    @Size(min = 4, max = 4)
    private String expDate;

    @JsonProperty("tranCurrencyCode")
    @NotBlank(message = "transaction Currency Code date is mandatory")
    @Size(max = 3)
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    @NotNull(message = "transaction amount should not be empty or null")
    private Double tranAmount;

    @JsonProperty("cashBackAmount")
    @NotBlank(message = "Cash Back Amount date is mandatory")
    private Boolean cashBackAmount;

    @JsonProperty("track2")
    @Size(min = 33, max = 37)
    private String track2;

    @JsonProperty("checkDuplicate")
    @NotBlank(message = "check duplicate date is mandatory")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    @NotBlank(message = "transaction auth type date is mandatory")
    @Size(min = 2, max = 2, message = "fromAccountType size should be 2")
    @Pattern(regexp = "\\d+")
    private String tranAuthenticationType;

}
