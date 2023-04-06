package com.goal.merchantsimulator.config;


import com.goal.merchantsimulator.dto.inbound.*;
import com.goal.merchantsimulator.dto.outbound.*;
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

        @Override
        public void purchaseMobileMapper(PurchaseMobileRequest purchaseMobileRequest, PurchaseMobileResponse purchaseMobileResponse) {

        }

        @Override
        public void purchaseWithCashBackMapper(PurchaseWithCashBackRequest purchaseWithCashBackRequest, PurchaseWithCashBackResponse purchaseWithCashBackResponse) {

        }

        @Override
        public void reverseBackMapper(ReversalRequest reversalRequest, ReversalResponse reversalResponse) {

        }

        @Override
        public void GetMiniStatementMapper(MiniStatementRequest miniStatementRequest, MiniStatementResponse miniStatementResponse) {

        }

        @Override
        public void getBillInquiryMapper(BillInquiryRequest billInquiryRequest, BillInquiryResponse billInquiryResponse) {

        }

        @Override
        public void billPrepaymentMapper(BillPrepaymentRequest billPrepaymentRequest, BillPrepaymentResponse billPrepaymentResponse) {

        }

        @Override
        public void billPaymentMapper(BillPaymentRequest billPaymentResponse, BillPaymentResponse billPaymentRequest) {

        }

        @Override
        public void balanceInquiryMapper(BalanceInquiryRequest balanceInquiryRequest, BalanceInquiryResponse balanceInquiryResponse) {

        }

        @Override
        public void changePINMapper(PINChangeRequest pinChangeRequest, PINChangeResponse pinChangeResponse) {

        }

        @Override
        public void cashInMapper(CashInRequest cashInRequest, CashInResponse cashInResponse) {

        }

        @Override
        public void refundMapper(RefundRequest refundRequest, RefundResponse refundResponse) {

        }

        @Override
        public void generateVoucherMapper(GenerateVoucherRequest generateVoucherRequest, GenerateVoucherResponse generateVoucherResponse) {

        }

        @Override
        public void cashOutVoucherMapper(CashOutVoucherRequest cashOutVoucherRequest, CashOutVoucherResponse cashOutVoucherResponse) {

        }

        @Override
        public void cardTransferMapper(CardTransferRequest cardTransferRequest, CardTransferResponse cardTransferResponse) {

        }

        @Override
        public void accountTransferMapper(AccountTransferRequest cardTransferRequest, AccountTransferResponse cardTransferResponse) {

        }

        @Override
        public void voucherCashInMapper(VoucherCashInRequest voucherCashInRequest, VoucherCashInResponse voucherCashInResponse) {

        }

        @Override
        public void networkTestMapper(DefaultRequest defaultRequest, GeneralResponse generalResponse) {

        }

        @Override
        public void payeesListMapper(DefaultRequest defaultRequest, PayeesListResponse payeesListResponse) {

        }

        @Override
        public void workingKeyMapper(DefaultRequest defaultRequest, WorkingKeyResponse workingKeyResponse) {

        }

        @Override
        public void cashOutMapper(CashOutRequest cashOutRequest, CashOutResponse cashOutResponse) {

        }

        @Override
        public void transactionStatusMapper(TransactionStatusRequest transactionStatusRequest, TransactionStatusResponse transactionStatusResponse) {

        }

        @Override
        public void voidPurchaseMapper(VoidPurchaseRequest voidPurchaseRequest, VoidPurchaseResponse voidPurchaseResponse) {

        }

        @Override
        public void completeTransactionMapper(DefaultRequest defaultRequest, CompleteTransactionResponse completeTransactionResponse) {

        }
    };
    };

}
