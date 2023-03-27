package com.goal.merchantsimulator.dto.outbound;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class AdminGeneralResponse {

    int code;

    String message;

    Object body;
}
