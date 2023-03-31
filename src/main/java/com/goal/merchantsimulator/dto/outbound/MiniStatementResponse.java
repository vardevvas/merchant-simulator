package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MiniStatementResponse extends GeneralResponse {

    @JsonProperty("pan")
    private String pan;

    @JsonProperty("miniStatementRecords")
    private List<Object> miniStatementRecords;

    @JsonProperty("tranFee")
    private Double tranFee;

    @JsonProperty("referenceNumber")
    private String referenceNumber;

    @JsonProperty("approvalCode")
    private String approvalCode;

}
