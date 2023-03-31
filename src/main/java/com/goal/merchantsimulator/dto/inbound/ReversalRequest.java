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
public class ReversalRequest extends DefaultRequest{

    @JsonProperty("pan")
    @Pattern(regexp = "^(?=[0-9]*$)(?:.{16}|.{19})$", message = "PAN must be either 16 or 19 numbers")
    @NotBlank(message = "pan is mandatory")
    private String pan;

    @JsonProperty("expiry_date")
    @NotBlank(message = "expiry date is mandatory")
    @Size(min = 4, max = 4)
    private String expDate;

    @JsonProperty("originalTranSystemTraceAuditNumber")
    @NotBlank(message = "Original transaction system trace audit number is mandatory")
    private String originalTranSystemTraceAuditNumber;

    @JsonProperty("serviceId")
    @NotBlank(message = "service Id date is mandatory")
    private String serviceId;

    @JsonProperty("checkDuplicate")
    @NotBlank(message = "check duplicate date is mandatory")
    private Boolean checkDuplicate;

}
