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
//
//    void publicKeyMapper(GetPublicKeyRequest getPublicKeyRequest, @MappingTarget GetPublicKeyResponse getPublicKeyResponse);
//
//    void registrationMapper(RegisterRequest registerRequest, @MappingTarget RegisterResponse registerResponse);
//
//    void completeCardRegisterMapper(CompleteCardRegistrationRequest cardRegistrationRequest, @MappingTarget CompleteCardRegistrationResponse completeCardRegistrationResponse);
//
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void balanceMapper(BalanceInquiryRequest balanceInquiryRequest, @MappingTarget BalanceInquiryResponse balanceInquiryResponse);
//
//    void paymentMapper(PaymentRequest paymentRequest, @MappingTarget PaymentResponse paymentResponse);
//
//    void billMapper(BillInquiryRequest billInquiryRequest, @MappingTarget BillInquiryResponse billInquiryResponse);
//
//    void cardTransferMapper(CardTransferRequest cardTransferRequest, @MappingTarget CardTransferResponse cardTransferResponse);
//
//    void isAliveMapper(EchoTestRequest echoTestRequest, @MappingTarget EchoTestResponse echoTestResponse);
//
//    void payeesListMapper(PayeesListRequest payeesListRequest,@MappingTarget PayeesListResponse payeesListResponse);
//
//    void changeIpinMapper(ChangeIPinRequest changeIPinRequest,@MappingTarget ChangeIPinResponse changeIPinResponse);
//
//    void changePasswordMapper(ChangePasswordRequest changePasswordRequest,@MappingTarget ChangePasswordResponse changePasswordResponse);
//
//    void forgetPasswordMapper(ForgetPasswordRequest forgetPasswordRequest,@MappingTarget ForgetPasswordResponse forgetPasswordResponse);
//
//    void adminResetPasswordMapper(AdminResetPaaswordRequest adminResetPaaswordRequest,@MappingTarget AdminResetPasswordResponse adminResetPasswordResponse);
//
//    void voucherMapper(GenerateVoucherRequest generateVoucherRequest,@MappingTarget GenerateVoucherResponse generateVoucherResponse);
//
//    void specialPaymentMapper(ServicePaymentRequest servicePaymentRequest,@MappingTarget ServicePaymentResponse servicePaymentResponse);
//
//    void transactionStatusMapper(TransactionStatusRequest transactionStatusRequest,@MappingTarget TransactionStatusResponse transactionStatusResponse);
//
//    void updateCardMapper(UpdateCardRegistrationRequest updateCardRegistrationRequest,@MappingTarget UpdateCardRegistrationResponse updateCardRegistrationResponse);
//
//    void accountTransferMapper(AccountTransferRequest accountTransferRequest,@MappingTarget AccountTransferResponse accountTransferResponse);
//
//    void merchantRegistrationMapper(MerchantRegistrationRequest merchantRegistrationRequest,@MappingTarget MerchantRegistrationResponse merchantRegistrationResponse);
//
//    void qrPurchaseMapper(QrPurchaseRequest qrPurchaseRequest,@MappingTarget QrPurchaseResponse qrPurchaseResponse);
//
//    void qrRefundMapper(QrRefundRequest qrRefundRequest,@MappingTarget QrRefundResponse qrRefundResponse);
//
//    void merchantTransactionsMapper(MerchantTransactionStatusRequest merchantTransactionStatusRequest,@MappingTarget MerchantTransactionStatusResponse merchantTransactionStatusResponse);
//
//    void inquirePanMapper(InquirePanRequest inquirePanRequest,@MappingTarget InquirePanResponse inquirePanResponse);
//
//    void completeTransactionMapper(CompleteTransactionRequest completeTransactionRequest,@MappingTarget CompleteTransactionResponse completeTransactionResponse);
//
//    void customerInfoMapper(GetCustomerInfoRequest getCustomerInfoRequest,@MappingTarget GetCustomerInfoResponse getCustomerInfoResponse);
//
//    void cashInMapper(DoCashInRequest doCashInRequest,@MappingTarget DoCashInResponse doCashInResponse);
//
//    void cashOutMapper(DoCashOutRequest doCashOutRequest,@MappingTarget DoCashOutResponse doCashOutResponse);
}
