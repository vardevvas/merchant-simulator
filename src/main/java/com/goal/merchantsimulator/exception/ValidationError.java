package com.goal.merchantsimulator.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {

    private String responseCode;
    private String responseMessage;
    private String responseStatus;
    private Map<String, String> goalAssistant;
}