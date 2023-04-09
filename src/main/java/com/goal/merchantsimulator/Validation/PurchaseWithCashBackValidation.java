package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.dto.inbound.BalanceInquiryRequest;
import com.goal.merchantsimulator.dto.inbound.PurchaseWithCashBackRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public interface PurchaseWithCashBackValidation extends Function<PurchaseWithCashBackRequest, Map<Object,Object >> {

    default PurchaseWithCashBackValidation and(PurchaseWithCashBackValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
