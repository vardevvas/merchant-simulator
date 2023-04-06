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
public class CashOutVoucherRequest extends DefaultRequest{

    @JsonProperty("phoneNumber")
    @NotNull(message = "Phone Number should not be empty or null")
    @Size(min = 12, max = 12)
    private String phoneNumber;

    @JsonProperty("voucherNumber")
    @NotNull(message = "Phone Number should not be empty or null")
    @Size(min = 6, max = 30)
    private Integer voucherNumber;

    @JsonProperty("tranAmount")
    @NotNull(message = "transaction amount should not be empty or null")
    private Double tranAmount;

}
