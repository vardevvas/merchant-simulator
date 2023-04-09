package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.dto.inbound.BillPaymentRequest;
import com.goal.merchantsimulator.dto.inbound.BillPrepaymentRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public interface BillPrepaymentValidation extends Function<BillPrepaymentRequest, Map<Object,Object >> {

    default BillPrepaymentValidation and(BillPrepaymentValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
