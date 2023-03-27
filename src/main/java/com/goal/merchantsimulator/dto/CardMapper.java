package com.goal.merchantsimulator.dto;

import com.goal.merchantsimulator.dto.inbound.CardRequest;
import com.goal.merchantsimulator.model.Card;

public class CardMapper {

    public static Card toMapper(CardRequest cardRequest){
        return new Card(null, cardRequest.getPan(), cardRequest.getBalance(), cardRequest.getExpDate(), cardRequest.getPhone(), cardRequest.getBank(), cardRequest.getBranch(), cardRequest.getName(), cardRequest.getMbr(), cardRequest.getStatus(),cardRequest.getIpin());
    }
}
