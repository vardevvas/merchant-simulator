package com.goal.merchantsimulator.dto.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CompleteTransactionResponse extends GeneralResponse {

    @JsonProperty("orgTranResponseCode")
    private Integer orgTranResponseCode;

    @JsonProperty("orgTranResponseMessage")
    private String orgTranResponseMessage;

    @JsonProperty("orgTranResponseStatus")
    private String orgTranResponseStatus;

}
