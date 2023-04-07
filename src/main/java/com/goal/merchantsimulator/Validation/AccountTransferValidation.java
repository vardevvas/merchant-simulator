package com.goal.merchantsimulator.Validation;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.inbound.AccountTransferRequest;
import com.goal.merchantsimulator.model.Card;
import com.goal.merchantsimulator.model.Terminal;
import com.goal.merchantsimulator.repository.CardRepo;
import com.goal.merchantsimulator.repository.TerminalRepo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public interface AccountTransferValidation extends Function<AccountTransferRequest, Map<Object,Object >> {

    static AccountTransferValidation isPanValid(CardRepo cardRepo) {
        Map<Object,Object> res = new HashMap<>();
        return accountTransferRequest -> {
            Optional<Card> card = cardRepo.findByPan(accountTransferRequest.getPan());
            if(accountTransferRequest.getPan() == null || card.isEmpty() || !card.get().getExpDate().equals(accountTransferRequest.getExpDate())){
                res.clear();
                res.put("code", Constant.ResponseCode.InvalidCard.code);
                res.put("msg", Constant.ResponseCode.InvalidCard.msg);
            }
                res.put("code",Constant.ResponseCode.Success.code);
                res.put("msg",Constant.ResponseCode.Success.msg);
                res.put("status","Successful");
                return res;
            };
    }

    default AccountTransferValidation and(AccountTransferValidation other) {
        return defaultRequest -> {
            Map<Object,Object > result = this.apply(defaultRequest);
            return result.containsValue(0) ? other.apply(defaultRequest) : result;
        };
    }
}
