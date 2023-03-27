package com.goal.merchantsimulator.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PurchaseRequest {

    @JsonProperty("clientId")
    private Long clientId;

    @JsonProperty("terminalId")
    private Long terminalId;

    @JsonProperty("tranDateTime")
    private Date tranDateTime;

    @JsonProperty("systemTraceAuditNumber")
    private Long systemTraceAuditNumber;

    @JsonProperty("pan")
    @Pattern(regexp = "^(?=[0-9]*$)(?:.{16}|.{19})$", message = "PAN must be either 16 or 19")
    @NotBlank(message = "pan is mandatory")
    private String pan;

    @JsonProperty("pin")
    @NotNull(message = "PIN should not be empty or null")
    private String pin;

    @JsonProperty("expiry_date")
    @NotBlank(message = "expiry date is mandatory")
    private String expDate;

    @JsonProperty("tranCurrencyCode")
    private String tranCurrencyCode;

    @JsonProperty("tranAmount")
    private Double tranAmount;

    @JsonProperty("additionalAmount")
    private Double additionalAmount;

    @JsonProperty("track2")
    private String track2;

    @JsonProperty("checkDuplicate")
    private Boolean checkDuplicate;

    @JsonProperty("tranAuthenticationType")
    private String tranAuthenticationType;

}
