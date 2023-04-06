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
public class VoucherCashInRequest extends DefaultRequest{

    @JsonProperty("voucherNumber")
    @NotNull(message = "Phone Number should not be empty or null")
    @Size(min = 6, max = 30)
    private Integer voucherNumber;

    @JsonProperty("approvalCode")
    private String approvalCode;

    @JsonProperty("tranAmount")
    @NotNull(message = "transaction amount should not be empty or null")
    private Double tranAmount;

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

    @JsonProperty("track2")
    @Size(min = 33, max = 37)
    private String track2;

}
