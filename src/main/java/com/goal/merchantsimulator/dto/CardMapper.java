package com.goal.merchantsimulator.dto;

import com.goal.consumersimulator.dto.inbound.CardRequest;
import com.goal.consumersimulator.model.Card;

public class CardMapper {

    public static Card toMapper(CardRequest cardRequest){
        return new Card(null, cardRequest.getPan(), cardRequest.getBalance(), cardRequest.getExpDate(), cardRequest.getPhone(), cardRequest.getBank(), cardRequest.getBranch(), cardRequest.getName(), cardRequest.getMbr(), cardRequest.getStatus(),cardRequest.getIpin());
    }
}
