package com.goal.merchantsimulator.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@AllArgsConstructor
@Data
public class CardRequest {

    @JsonProperty("PAN")
    @Pattern(regexp = "^(?=[0-9]*$)(?:.{16}|.{19})$", message = "PAN must be either 16 or 19")
    @NotBlank(message = "pan is mandatory")
    private String pan;

    @JsonProperty("balance")
    private Double balance;

    @JsonProperty("expiry_date")
    @NotBlank(message = "expiry date is mandatory")
    private String expDate;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("bank")
    private String bank;

    @JsonProperty("branch")
    private String branch;

    @JsonProperty("name")
    private String name;

    @JsonProperty("mbr")
    private String mbr;

    @JsonProperty("status")
    private String status;

    @JsonProperty("IPIN")
    @NotNull(message = "IPIN should not be empty or null")
    private String ipin;
}
