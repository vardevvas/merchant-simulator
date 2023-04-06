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
public class BalanceInquiryRequest extends DefaultRequest{

    @JsonProperty("pan")
    @Pattern(regexp = "^(?=[0-9]*$)(?:.{16}|.{19})$", message = "PAN must be either 16 or 19 numbers")
    @NotBlank(message = "pan is mandatory")
    private String pan;

    @JsonProperty("pin")
    @NotNull(message = "PIN should not be empty or null")
    @Size(min = 16, max = 16)
    private String pin;

    @JsonProperty("tranCurrencyCode")
    @NotBlank(message = "transaction Currency Code date is mandatory")
    @Size(max = 3)
    private String tranCurrencyCode;

    @JsonProperty("track2")
    @Size(min = 33, max = 37)
    private String track2;

    @JsonProperty("tranAuthenticationType")
    @NotBlank(message = "transaction auth type date is mandatory")
    @Size(min = 2, max = 2, message = "fromAccountType size should be 2")
    @Pattern(regexp = "\\d+")
    private String tranAuthenticationType;

}
