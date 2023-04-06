package com.goal.merchantsimulator.mapper;

import com.goal.merchantsimulator.dto.inbound.*;
import com.goal.merchantsimulator.dto.outbound.*;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface EbsMapper {
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void purchaseMapper(PurchaseRequest purchaseRequest, @MappingTarget PurchaseResponse purchaseResponse);
    void purchaseMobileMapper(PurchaseMobileRequest purchaseMobileRequest, @MappingTarget PurchaseMobileResponse purchaseMobileResponse);
    void purchaseWithCashBackMapper(PurchaseWithCashBackRequest purchaseWithCashBackRequest, @MappingTarget PurchaseWithCashBackResponse purchaseWithCashBackResponse);
    void reverseBackMapper(ReversalRequest reversalRequest, @MappingTarget ReversalResponse reversalResponse);
    void GetMiniStatementMapper(MiniStatementRequest miniStatementRequest, @MappingTarget MiniStatementResponse miniStatementResponse);
    void getBillInquiryMapper(BillInquiryRequest billInquiryRequest, @MappingTarget BillInquiryResponse billInquiryResponse);
    void billPrepaymentMapper(BillPrepaymentRequest billPrepaymentRequest, @MappingTarget BillPrepaymentResponse billPrepaymentResponse);
    void billPaymentMapper(BillPaymentRequest billPaymentResponse, @MappingTarget BillPaymentResponse billPaymentRequest);
    void balanceInquiryMapper(BalanceInquiryRequest balanceInquiryRequest, @MappingTarget BalanceInquiryResponse balanceInquiryResponse);
    void changePINMapper(PINChangeRequest pinChangeRequest, @MappingTarget PINChangeResponse pinChangeResponse);
    void cashInMapper(CashInRequest cashInRequest, @MappingTarget CashInResponse cashInResponse);
    void refundMapper(RefundRequest refundRequest, @MappingTarget RefundResponse refundResponse);
    void generateVoucherMapper(GenerateVoucherRequest generateVoucherRequest, @MappingTarget GenerateVoucherResponse generateVoucherResponse);

}
