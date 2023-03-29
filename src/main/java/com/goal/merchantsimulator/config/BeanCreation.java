package com.goal.merchantsimulator.config;


import com.goal.merchantsimulator.dto.inbound.PurchaseRequest;
import com.goal.merchantsimulator.dto.outbound.PurchaseResponse;
import com.goal.merchantsimulator.mapper.EbsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreation {

    @Bean
    EbsMapper ebsMapper(){return new EbsMapper() {
        @Override
        public void purchaseMapper(PurchaseRequest purchaseRequest, PurchaseResponse purchaseResponse) {

        }
    };
    };

}
