package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.inbound.AccountTransferRequest;
import com.goal.merchantsimulator.dto.inbound.BalanceInquiryRequest;
import com.goal.merchantsimulator.model.Card;
import com.goal.merchantsimulator.repository.CardRepo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public interface BalanceInquiryValidation extends Function<BalanceInquiryRequest, Map<Object,Object >> {

    default BalanceInquiryValidation and(BalanceInquiryValidation other) {
        return request -> {
            Map<Object,Object > result = this.apply(request);
            return result.containsValue(0) ? other.apply(request) : result;
        };
    }
}
