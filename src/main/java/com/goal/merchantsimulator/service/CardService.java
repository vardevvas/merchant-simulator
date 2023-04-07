package com.goal.merchantsimulator.service;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.CardMapper;
import com.goal.merchantsimulator.dto.inbound.CardRequest;
import com.goal.merchantsimulator.dto.outbound.AdminGeneralResponse;
import com.goal.merchantsimulator.model.Card;
import com.goal.merchantsimulator.repository.CardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepo cardRepo;

    public Map isPanValid(String pan, String expDate, Map res) {
            Optional<Card> card = cardRepo.findByPan(pan);
            if(pan == null || card.isEmpty() || !card.get().getExpDate().equals(expDate)){
                res.put("code", Constant.ResponseCode.InvalidCard.code);
                res.put("msg", Constant.ResponseCode.InvalidCard.msg);
                res.put("status", "Failed");
            }
            return res;
    }

    public AdminGeneralResponse save(CardRequest cardRequest){
        Optional<Card> cardOptional = cardRepo.findByPan(cardRequest.getPan());
        if (cardOptional.isEmpty()){
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,cardRepo.save(CardMapper.toMapper(cardRequest)));
        }
        return new AdminGeneralResponse(-1,"Card already exists",null);
    }

    public AdminGeneralResponse delete(Long id){
        Optional<Card> cardOptional = cardRepo.findById(id);
        if (cardOptional.isPresent()){
            cardRepo.delete(cardOptional.get());
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,null);
        }
        return new AdminGeneralResponse(-2,"Card not found",null);
    }

    public AdminGeneralResponse update(CardRequest cardRequest, Long id){
        Optional<Card> cardOptional = cardRepo.findById(id);
        if (cardOptional.isPresent()){
            Card card = cardOptional.get();
            card.setPan(cardRequest.getPan()).setBalance(cardRequest.getBalance()).setExpDate(card.getExpDate()).setStatus(cardRequest.getStatus());
            return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,cardRepo.save(card));
        }
        return new AdminGeneralResponse(-2,"Card not found",null);

    }

    public AdminGeneralResponse getCard(Long id){
        return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,cardRepo.findById(id));
    }

    public AdminGeneralResponse getCards(){
        return new AdminGeneralResponse(Constant.ResponseCode.Success.code,Constant.ResponseCode.Success.msg,cardRepo.findAll());
    }
}
