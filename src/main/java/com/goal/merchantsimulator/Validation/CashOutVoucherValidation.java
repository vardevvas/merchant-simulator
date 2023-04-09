package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.dto.inbound.BalanceInquiryRequest;
import com.goal.merchantsimulator.dto.inbound.CashOutVoucherRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public interface CashOutVoucherValidation extends Function<CashOutVoucherRequest, Map<Object,Object >> {

    default CashOutVoucherValidation and(CashOutVoucherValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
