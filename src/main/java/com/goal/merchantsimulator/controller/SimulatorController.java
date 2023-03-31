package com.goal.merchantsimulator.controller;

import com.goal.merchantsimulator.dto.inbound.*;
import com.goal.merchantsimulator.dto.outbound.*;
import com.goal.merchantsimulator.service.EbsServices;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;



@RequestMapping("/merchant")
@RestController
@CrossOrigin()
@RequiredArgsConstructor
public class SimulatorController {

    final private EbsServices ebsServices;

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> purchase(@Validated @RequestBody PurchaseRequest request) {
        return new ResponseEntity<>(ebsServices.purchase(request), HttpStatus.OK);

    }

    @PostMapping("/purchaseMobile")
    public ResponseEntity<PurchaseMobileResponse> purchaseMobile(@Validated @RequestBody PurchaseMobileRequest request) {
        return new ResponseEntity<>(ebsServices.purchaseMobile(request), HttpStatus.OK);

    }

    @PostMapping("/purchaseWithCashBack")
    public ResponseEntity<PurchaseWithCashBackResponse> purchaseWithCashBack(@Validated @RequestBody PurchaseWithCashBackRequest request) {
        return new ResponseEntity<>(ebsServices.purchaseWithCashBack(request), HttpStatus.OK);

    }

    @PostMapping("/reverse")
    public ResponseEntity<ReversalResponse> reverse(@Validated @RequestBody ReversalRequest request) {
        return new ResponseEntity<>(ebsServices.reverse(request), HttpStatus.OK);

    }

    @PostMapping("/getMiniStatement")
    public ResponseEntity<MiniStatementResponse> GetMiniStatement(@Validated @RequestBody MiniStatementRequest request) {
        return new ResponseEntity<>(ebsServices.GetMiniStatement(request), HttpStatus.OK);

    }

//    @PostMapping(path = "/getPublicKey")
//    public ResponseEntity<GetPublicKeyResponse> getPublicKeyRequest(@Validated @RequestBody GetPublicKeyRequest publicKeyRequest) throws IOException {
//        System.out.println("Test" + new Gson().toJson(publicKeyRequest));
//        return new ResponseEntity<>(ebsServices.getPublicKeyRequest(publicKeyRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/register")
//    public ResponseEntity<RegisterResponse> register(@Validated @RequestBody RegisterRequest registerRequest) {
//        return new ResponseEntity<>(ebsServices.register(registerRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/completeCardRegistration")
//    public ResponseEntity<CompleteCardRegistrationResponse> completeCardRegistration(@Validated @RequestBody CompleteCardRegistrationRequest cardRegistrationRequest) {
//        return new ResponseEntity<>(ebsServices.completeCardRegistration(cardRegistrationRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getBalance")
//    public ResponseEntity<BalanceInquiryResponse> getBalance(@Validated @RequestBody BalanceInquiryRequest balanceInquiryRequest) {
//        return new ResponseEntity<>(ebsServices.getBalance(balanceInquiryRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getBill")
//    public ResponseEntity<?> getBill(@Validated @RequestBody BillInquiryRequest billInquiryRequest) {
//        return new ResponseEntity<>(ebsServices.getBill(billInquiryRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/payment")
//    public ResponseEntity<PaymentResponse> payment(@Validated @RequestBody PaymentRequest paymentRequest) {
//        return new ResponseEntity<>(ebsServices.payment(paymentRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doCardTransfer")
//    public ResponseEntity<CardTransferResponse> doCardTransfer(@Validated @RequestBody CardTransferRequest cardTransferRequest) {
//        return new ResponseEntity<>(ebsServices.doCardTransfer(cardTransferRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/isAlive")
//    public ResponseEntity<EchoTestResponse> isAlive(@Validated @RequestBody EchoTestRequest echoTestRequest) {
//        return new ResponseEntity<>(ebsServices.isAlive(echoTestRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getPayeesList")
//    public ResponseEntity<PayeesListResponse> getPayeesList(@Validated @RequestBody PayeesListRequest payeesListRequest) {
//        return new ResponseEntity<>(ebsServices.getPayeesList(payeesListRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/changeIPin")
//    public ResponseEntity<ChangeIPinResponse> changeIPin(@Validated @RequestBody ChangeIPinRequest changeIPinRequest) {
//        return new ResponseEntity<>(ebsServices.changeIPin(changeIPinRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/changePassword")
//    public ResponseEntity<ChangePasswordResponse> changePassword(@Validated @RequestBody ChangePasswordRequest changePasswordRequest) {
//        return new ResponseEntity<>(ebsServices.changePassword(changePasswordRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/forgetPassword")
//    public ResponseEntity<ForgetPasswordResponse> forgetPassword(@Validated @RequestBody ForgetPasswordRequest forgetPasswordRequest) {
//        return new ResponseEntity<>(ebsServices.forgetPassword(forgetPasswordRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/adminResetPassword")
//    public ResponseEntity<AdminResetPasswordResponse> adminResetPassword(@Validated @RequestBody AdminResetPaaswordRequest adminResetPaaswordRequest) {
//        return new ResponseEntity<>(ebsServices.adminResetPassword(adminResetPaaswordRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/generateVoucher")
//    public ResponseEntity<GenerateVoucherResponse> generateVoucher(@Validated @RequestBody GenerateVoucherRequest generateVoucherRequest) {
//        return new ResponseEntity<>(ebsServices.generateVoucher(generateVoucherRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/specialPayment")
//    public ResponseEntity<ServicePaymentResponse> specialPayment(@Validated @RequestBody ServicePaymentRequest servicePaymentRequest) {
//        return new ResponseEntity<>(ebsServices.specialPayment(servicePaymentRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getTransactionStatus")
//    public ResponseEntity<TransactionStatusResponse> getTransactionStatus(@Validated @RequestBody TransactionStatusRequest transactionStatusRequest) {
//        return new ResponseEntity<>(ebsServices.getTransactionStatus(transactionStatusRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/updateRegisteredCard")
//    public ResponseEntity<UpdateCardRegistrationResponse> updateRegisteredCard(@Validated @RequestBody UpdateCardRegistrationRequest updateCardRegistrationRequest) {
//        return new ResponseEntity<>(ebsServices.updateRegisteredCard(updateCardRegistrationRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doAccountTransfer")
//    public ResponseEntity<AccountTransferResponse> doAccountTransfer(@Validated @RequestBody AccountTransferRequest accountTransferRequest) {
//        return new ResponseEntity<>(ebsServices.doAccountTransfer(accountTransferRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doMerchantsRegistration")
//    public ResponseEntity<MerchantRegistrationResponse> doMerchantsRegistration(@Validated @RequestBody MerchantRegistrationRequest merchantRegistrationRequest) {
//        return new ResponseEntity<>(ebsServices.doMerchantsRegistration(merchantRegistrationRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doQRPurchase")
//    public ResponseEntity<QrPurchaseResponse> doQRPurchase(@Validated @RequestBody QrPurchaseRequest qrPurchaseRequest) {
//        return new ResponseEntity<>(ebsServices.doQRPurchase(qrPurchaseRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doQRRefund")
//    public ResponseEntity<QrRefundResponse> doQRRefund(@Validated @RequestBody QrRefundRequest qrRefundRequest) {
//        return new ResponseEntity<QrRefundResponse>(ebsServices.doQRRefund(qrRefundRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getMerchantTransactions")
//    public ResponseEntity<MerchantTransactionStatusResponse> getMerchantTransactions(@Validated @RequestBody MerchantTransactionStatusRequest merchantTransactionStatusRequest) {
//        return new ResponseEntity<>(ebsServices.getMerchantTransactions(merchantTransactionStatusRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/checkMsisdnAganistPAN")
//    public ResponseEntity<InquirePanResponse> checkMsisdnAganistPAN(@Validated @RequestBody InquirePanRequest inquirePanRequest) {
//        return new ResponseEntity<InquirePanResponse>(ebsServices.checkMsisdnAganistPAN(inquirePanRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/completeTransaction")
//    public ResponseEntity<CompleteTransactionResponse> completeTransaction(@Validated @RequestBody CompleteTransactionRequest completeTransactionRequest) {
//        return new ResponseEntity<CompleteTransactionResponse>(ebsServices.completeTransaction(completeTransactionRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getCustomerInfo")
//    public ResponseEntity<GetCustomerInfoResponse> getCustomerInfo(@Validated @RequestBody GetCustomerInfoRequest getCustomerInfoRequest) {
//        return new ResponseEntity<>(ebsServices.getCustomerInfo(getCustomerInfoRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doCashIn")
//    public ResponseEntity<DoCashInResponse> doCashIn(@Validated @RequestBody DoCashInRequest doCashInRequest) {
//        return new ResponseEntity<>(ebsServices.doCashIn(doCashInRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/doCashOut")
//    public ResponseEntity<DoCashOutResponse> doCashOut(@Validated @RequestBody DoCashOutRequest doCashOutRequest) {
//        return new ResponseEntity<DoCashOutResponse>(ebsServices.doCashOut(doCashOutRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getFileEncryptionKey")
//    public ResponseEntity<GetFileEncryptionResponse> getFileEncryptionKey(@Validated @RequestBody GetFileEncryptionRequest getFileEncryptionRequest) {
//        return new ResponseEntity<GetFileEncryptionResponse>(ebsServices.getFileEncryptionKey(getFileEncryptionRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/getBatchStatus")
//    public ResponseEntity<DoCashOutResponse> getBatchStatus(@Validated @RequestBody DoCashOutRequest doCashOutRequest) {
//        return new ResponseEntity<DoCashOutResponse>(ebsServices.getBatchStatus(doCashOutRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/processFileBatch")
//    public ResponseEntity<> processFileBatch(@Validated @RequestBody DoCashOutRequest doCashOutRequest) {
//        return new ResponseEntity<>(ebsServices.processFileBatch(doCashOutRequest), HttpStatus.OK);
//
//    }
//
//    @PostMapping(path = "/processOnlineBatch")
//    public ResponseEntity<DoCashOutResponse> doCasprocessOnlineBatchhOut(@Validated @RequestBody DoCashOutRequest doCashOutRequest) {
//        return new ResponseEntity<DoCashOutResponse>(ebsServices.processOnlineBatch(doCashOutRequest), HttpStatus.OK);
//
//    }

}
