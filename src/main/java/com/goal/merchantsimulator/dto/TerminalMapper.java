package com.goal.merchantsimulator.dto;

import com.goal.merchantsimulator.dto.inbound.TerminalRequest;
import com.goal.merchantsimulator.model.Terminal;

public class TerminalMapper {

    public static Terminal toMapper(TerminalRequest terminalRequest){
        return new Terminal(null, terminalRequest.getClientId(), terminalRequest.getSystemTraceAuditNumber(),"PENDING", terminalRequest.getNotes());
    }
}
