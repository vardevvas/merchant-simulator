package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.dto.inbound.BalanceInquiryRequest;
import com.goal.merchantsimulator.dto.inbound.PurchaseMobileRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public interface PurchaseMobileValidation extends Function<PurchaseMobileRequest, Map<Object,Object >> {

    default PurchaseMobileValidation and(PurchaseMobileValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
