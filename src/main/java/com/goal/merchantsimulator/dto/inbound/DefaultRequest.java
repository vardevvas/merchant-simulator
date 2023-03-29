package com.goal.merchantsimulator.dto.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@MappedSuperclass
public class DefaultRequest {

    @JsonProperty("clientId")
    @Size(min = 1, max = 30)
    private Long clientId;

    @JsonProperty("terminalId")
    @Size(min = 1, max = 8)
    private Long terminalId;

    @JsonProperty(value = "tranDateTime")
    @NotBlank(message = "tranDateTime should not be empty or null")
    @Size(min = 12, max = 12, message = "tranDateTime size should be 12")
    private Date tranDateTime;

    @JsonProperty("systemTraceAuditNumber")
    @NotNull(message = "system Trace Audit Number should not be empty or null")
    private Long systemTraceAuditNumber;

}
