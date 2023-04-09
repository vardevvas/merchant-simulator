package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.dto.inbound.BalanceInquiryRequest;
import com.goal.merchantsimulator.dto.inbound.CardTransferRequest;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;

@Component
public interface CardTransferValidation extends Function<CardTransferRequest, Map<Object,Object >> {

    default CardTransferValidation and(CardTransferValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
