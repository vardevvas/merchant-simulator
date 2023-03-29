package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.inbound.DefaultRequest;
import com.goal.merchantsimulator.dto.inbound.PurchaseRequest;
import com.goal.merchantsimulator.model.Terminal;
import com.goal.merchantsimulator.repository.TerminalRepo;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@FunctionalInterface
@Component
public interface DefaultValidation extends Function<DefaultRequest, Map<Object,Object >> {

    static DefaultValidation isClientIdValid(TerminalRepo terminalRepo) {
        Map<Object,Object> res = new HashMap<>();
        return defaultRequest -> {
            Optional<Terminal> terminalOptional = terminalRepo.findByClientId(defaultRequest.getClientId());
            if(terminalOptional.isEmpty()){
                res.put("code", Constant.ResponseCode.InvalidClientId.code);
                res.put("msg",Constant.ResponseCode.InvalidClientId.msg);
                res.put("status","Failed");
                return res;
            }
            res.put("code",Constant.ResponseCode.Success.code);
            res.put("msg",Constant.ResponseCode.Success.msg);
            res.put("status","Successful");
            return res;
        };
    }

    static DefaultValidation isTerminalIdValid(TerminalRepo terminalRepo) {
        Map<Object,Object> res = new HashMap<>();
        return defaultRequest -> {
            Optional<Terminal> terminalOptional = terminalRepo.findByTerminalId(defaultRequest.getTerminalId());
            if(terminalOptional.isEmpty()){
                res.put("code", Constant.ResponseCode.InvalidTerminalId.code);
                res.put("msg",Constant.ResponseCode.InvalidTerminalId.msg);
                res.put("status","Failed");
                return res;
            }
            res.put("code",Constant.ResponseCode.Success.code);
            res.put("msg",Constant.ResponseCode.Success.msg);
            res.put("status","Successful");
            return res;
        };
    }

    static DefaultValidation isSystemTraceAuditNumberValid(TerminalRepo terminalRepo) {
        Map<Object,Object> res = new HashMap<>();
        return defaultRequest -> {
            Optional<Terminal> terminalOptional = terminalRepo.findBySystemTraceAuditNumber(defaultRequest.getSystemTraceAuditNumber());
            if(terminalOptional.isEmpty()){
                res.put("code", Constant.ResponseCode.InvalidSystemTraceAuditNumber.code);
                res.put("msg",Constant.ResponseCode.InvalidSystemTraceAuditNumber.msg);
                res.put("status","Failed");
                return res;
            }
            res.put("code",Constant.ResponseCode.Success.code);
            res.put("msg",Constant.ResponseCode.Success.msg);
            res.put("status","Successful");
            return res;
        };
    }

    default DefaultValidation and(DefaultValidation other) {
        return defaultRequest -> {
            Map<Object,Object > result = this.apply(defaultRequest);
            return result.containsValue(0) ? other.apply(defaultRequest) : result;
        };
    }

}
