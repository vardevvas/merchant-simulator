package com.goal.merchantsimulator.service;

import com.goal.merchantsimulator.config.Constant;
import com.goal.merchantsimulator.dto.inbound.*;
import com.goal.merchantsimulator.dto.outbound.*;
import com.goal.merchantsimulator.mapper.EbsMapper;
import com.goal.merchantsimulator.repository.TerminalRepo;
import com.goal.merchantsimulator.repository.CardRepo;
import com.goal.merchantsimulator.repository.PayeesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.goal.merchantsimulator.Validation.DefaultValidation.*;

//import static com.goal.consumersimulator.Validation.AccountTransferValidation.*;
//import static com.goal.consumersimulator.Validation.AdminResetPasswordValidation.isAdminResetPasswordAppIdValid;
//import static com.goal.consumersimulator.Validation.AdminResetPasswordValidation.isAdminResetPasswordUuidValid;
//import static com.goal.consumersimulator.Validation.BalanceInquiryValidation.*;
//import static com.goal.consumersimulator.Validation.BillInquiryValidation.*;
//import static com.goal.consumersimulator.Validation.CardTransferValidation.*;
//import static com.goal.consumersimulator.Validation.CashINValidation.*;
//import static com.goal.consumersimulator.Validation.CashOUTValidation.*;
//import static com.goal.consumersimulator.Validation.ChangeIPINValidation.*;
//import static com.goal.consumersimulator.Validation.ChangePasswordValidation.*;
//import static com.goal.consumersimulator.Validation.CompleteCardRegistrationValidation.*;
//import static com.goal.consumersimulator.Validation.CompleteTransactionValidation.isCompleteTransactionAppIdValid;
//import static com.goal.consumersimulator.Validation.CompleteTransactionValidation.isCompleteTransactionUuidValid;
//import static com.goal.consumersimulator.Validation.EchoTestValidation.isEchoTestAppIdValid;
//import static com.goal.consumersimulator.Validation.EchoTestValidation.isEchoTestUuidValid;
//import static com.goal.consumersimulator.Validation.ForgetPasswordValidation.isForgetPasswordAppIdValid;
//import static com.goal.consumersimulator.Validation.ForgetPasswordValidation.isForgetPasswordUuidValid;
//import static com.goal.consumersimulator.Validation.GenerateVoucherValidation.*;
//import static com.goal.consumersimulator.Validation.GetCustomerInfoValidation.isGetCustomerInfoAppIdValid;
//import static com.goal.consumersimulator.Validation.GetCustomerInfoValidation.isGetCustomerInfoUuidValid;
//import static com.goal.consumersimulator.Validation.GetPayeesValidation.isAppIdValid;
//import static com.goal.consumersimulator.Validation.GetPayeesValidation.isGetPayeesUuidValid;
//import static com.goal.consumersimulator.Validation.GetPublicKeyValidation.isPublicKeyAppIdValid;
//import static com.goal.consumersimulator.Validation.GetPublicKeyValidation.isPublicKeyUuidValid;
//import static com.goal.consumersimulator.Validation.InquirePanValidation.isInquirePanAppIdValid;
//import static com.goal.consumersimulator.Validation.InquirePanValidation.isInquirePanUuidValid;
//import static com.goal.consumersimulator.Validation.MerchantRegistrationValidation.isMerchantRegistrationAppIdValid;
//import static com.goal.consumersimulator.Validation.MerchantRegistrationValidation.isMerchantRegistrationUuidValid;
//import static com.goal.consumersimulator.Validation.MerchantTransactionsValidation.*;
//import static com.goal.consumersimulator.Validation.PaymentValidation.*;
//import static com.goal.consumersimulator.Validation.QRPurchaseValidation.*;
//import static com.goal.consumersimulator.Validation.QRRefundValidation.*;
//import static com.goal.consumersimulator.Validation.RegisterValidation.*;
//import static com.goal.consumersimulator.Validation.SpecialPaymentValidation.*;
//import static com.goal.consumersimulator.Validation.TransactionStatusValidation.*;

@Service
@AllArgsConstructor
public class EbsServices {
    private final PayeesRepo payeesRepo;
    private final TerminalRepo terminalRepo;
    private final CardRepo cardRepo;
    private final EbsMapper ebsMapper;

    public PurchaseResponse purchase(PurchaseRequest purchaseRequest) {
        PurchaseResponse purchaseResponse = new PurchaseResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(purchaseRequest);
        ebsMapper.purchaseMapper(purchaseRequest, purchaseResponse);
        if (valid.containsValue(0)) {
            purchaseResponse.setResponseCode(Constant.ResponseCode.Success.code);
            purchaseResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
            purchaseResponse.setResponseStatus(Constant.ResponseCode.Success.status);
            return purchaseResponse;
        }
        purchaseResponse.setResponseCode((Integer) valid.get("code"));
        purchaseResponse.setResponseMessage((String) valid.get("msg"));
        purchaseResponse.setResponseStatus((String) valid.get("status"));
        return purchaseResponse;
    }

    public PurchaseMobileResponse purchaseMobile(PurchaseMobileRequest purchaseMobileRequest) {
        PurchaseMobileResponse purchaseMobileResponse = new PurchaseMobileResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(purchaseMobileRequest);
        if (valid.containsValue(0)) {
            purchaseMobileResponse.setResponseCode(Constant.ResponseCode.Success.code);
            purchaseMobileResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
            purchaseMobileResponse.setResponseStatus(Constant.ResponseCode.Success.status);
            return purchaseMobileResponse;
        }
        purchaseMobileResponse.setResponseCode((Integer) valid.get("code"));
        purchaseMobileResponse.setResponseMessage((String) valid.get("msg"));
        purchaseMobileResponse.setResponseStatus((String) valid.get("status"));
        return purchaseMobileResponse;

    }

    public PurchaseWithCashBackResponse purchaseWithCashBack(PurchaseWithCashBackRequest purchaseWithCashBackRequest) {
        PurchaseWithCashBackResponse purchaseWithCashBackResponse = new PurchaseWithCashBackResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(purchaseWithCashBackRequest);
        if (valid.containsValue(0)) {
            purchaseWithCashBackResponse.setResponseCode(Constant.ResponseCode.Success.code);
            purchaseWithCashBackResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
            purchaseWithCashBackResponse.setResponseStatus(Constant.ResponseCode.Success.status);
            return purchaseWithCashBackResponse;
        }
        purchaseWithCashBackResponse.setResponseCode((Integer) valid.get("code"));
        purchaseWithCashBackResponse.setResponseMessage((String) valid.get("msg"));
        purchaseWithCashBackResponse.setResponseStatus((String) valid.get("status"));
        return purchaseWithCashBackResponse;

    }

//    public GetPublicKeyResponse getPublicKeyRequest(GetPublicKeyRequest publicKeyRequest) throws IOException {
//        GetPublicKeyResponse getPublicKeyResponse = new GetPublicKeyResponse();
//        Map<Object, Object> valid = isPublicKeyAppIdValid(valid).and(isPublicKeyUuidValid()).apply(publicKeyRequest);
//        ebsMapper.publicKeyMapper(publicKeyRequest, getPublicKeyResponse);
//        if (valid.containsValue(0)) {
//            getPublicKeyResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            getPublicKeyResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            getPublicKeyResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            File publicKeyFile = new File("public.key");
//            byte[] publicKeyBytes = Files.readAllBytes(publicKeyFile.toPath());
//            getPublicKeyResponse.setPubKeyValue(Base64.getEncoder().encodeToString(publicKeyBytes));
//            return getPublicKeyResponse;
//        }
//        getPublicKeyResponse.setResponseCode((Integer) valid.get("code"));
//        getPublicKeyResponse.setResponseMessage((String) valid.get("msg"));
//        getPublicKeyResponse.setResponseStatus((String) valid.get("status"));
//        return getPublicKeyResponse;
//
//    }
//
//    public RegisterResponse register(RegisterRequest registerRequest) {
//        RegisterResponse registerResponse = new RegisterResponse();
//        Map<Object, Object> valid = isRegisterUuidValid().and(isRegisterIpinValid(cardRepo)).and(isRegisterAppIdValid(applicationRepo)).apply(registerRequest);
//        ebsMapper.registrationMapper(registerRequest, registerResponse);
//        if (valid.containsValue(0)) {
//            LocalDateTime localDateTime = LocalDateTime.now();
//            registerResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            registerResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            registerResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            registerResponse.setCreationDate(localDateTime.format(DateTimeFormatter.ofPattern("yyMM")));
//        }
//        registerResponse.setResponseCode((Integer) valid.get("code"));
//        registerResponse.setResponseMessage((String) valid.get("msg"));
//        registerResponse.setResponseStatus("Failed");
//        return registerResponse;
//    }
//
//    public CompleteCardRegistrationResponse completeCardRegistration(CompleteCardRegistrationRequest cardRegistrationRequest) {
//        CompleteCardRegistrationResponse completeCardRegistrationResponse = new CompleteCardRegistrationResponse();
//        Map<Object, Object> valid = isCompleteCardRegistrationAppIdValid(applicationRepo).and(isCardRegistrationIpinValid(cardRepo)).and(isCompleteCardRegistrationUuidValid()).apply(cardRegistrationRequest);
//        ebsMapper.completeCardRegisterMapper(cardRegistrationRequest, completeCardRegistrationResponse);
//        if (valid.containsValue(0)) {
//            completeCardRegistrationResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            completeCardRegistrationResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            completeCardRegistrationResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            completeCardRegistrationResponse.setUserName("");
//            completeCardRegistrationResponse.setEntityId("");
//            completeCardRegistrationResponse.setEntityType("");
//            completeCardRegistrationResponse.setEntityGroup("");
//            completeCardRegistrationResponse.setPan("");
//            completeCardRegistrationResponse.setMbr("");
//            completeCardRegistrationResponse.setEmail("");
//            completeCardRegistrationResponse.setPhoneNo("");
//            completeCardRegistrationResponse.setFinancialInstitutionId("");
//            completeCardRegistrationResponse.setRegistrationType("");
//            completeCardRegistrationResponse.setPanCategory("");
//            completeCardRegistrationResponse.setExpDate("");
//        }
//        completeCardRegistrationResponse.setResponseCode((Integer) valid.get("code"));
//        completeCardRegistrationResponse.setResponseMessage((String) valid.get("msg"));
//        completeCardRegistrationResponse.setResponseStatus("Failed");
//        return completeCardRegistrationResponse;
//    }
//
//    public BalanceInquiryResponse getBalance(BalanceInquiryRequest balanceInquiryRequest) {
//        BalanceInquiryResponse balanceInquiryResponse = new BalanceInquiryResponse();
//        Map<Object, Object> valid = isGetBalanceAppIdValid(applicationRepo).and(isGetBalanceUuidValid()).and(isGetBalanceIpinValid(cardRepo)).apply(balanceInquiryRequest);
//        ebsMapper.balanceMapper(balanceInquiryRequest, balanceInquiryResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(balanceInquiryRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//            balanceInquiryResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            balanceInquiryResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            balanceInquiryResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            balanceInquiryResponse.setBalance(balance);
//            balanceInquiryResponse.setFromAccount("110190457501869640");
//            balanceInquiryResponse.setAccountCurrency("SDG");
//            balanceInquiryResponse.setFromAccountType("00");
//        }
//        balanceInquiryResponse.setResponseCode((Integer) valid.get("code"));
//        balanceInquiryResponse.setResponseMessage((String) valid.get("msg"));
//        balanceInquiryResponse.setResponseStatus((String) valid.get("status"));
//
//        return balanceInquiryResponse;
//    }
//
//    public BillInquiryResponse getBill(BillInquiryRequest billInquiryRequest) {
//        BillInquiryResponse billInquiryResponse = new BillInquiryResponse();
//        Map<Object, Object> valid = isBillInfoValid().and(isBillInquiryIpinValid(cardRepo)).and(isBillInquiryEntityValid()).and(isInquiryPaymentMethodValid(cardRepo)).and(isBillInquiryUuidValid()).apply(billInquiryRequest);
//        ebsMapper.billMapper(billInquiryRequest, billInquiryResponse);
//        if (valid.containsValue(0)) {
//            billInquiryResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            billInquiryResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            billInquiryResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            billInquiryResponse.setBillInfo(processBillInquiryInfo(billInquiryRequest.getPayeeId()));
//            return billInquiryResponse;
//        }
//        billInquiryResponse.setResponseCode((Integer) valid.get("code"));
//        billInquiryResponse.setResponseStatus((String) valid.get("status"));
//        billInquiryResponse.setResponseMessage((String) valid.get("msg"));
//
//        return billInquiryResponse;
//    }
//
//    public PaymentResponse payment(PaymentRequest paymentRequest) {
//        PaymentResponse billPaymentResponse = new PaymentResponse();
//        Map<Object, Object> valid = isBillPaymentInfoValid().and(isBillPaymentIpinValid(cardRepo)).and(isBillPaymentMethodValid(cardRepo)).and(isBillPaymentUuidValid()).apply(paymentRequest);
//        ebsMapper.paymentMapper(paymentRequest, billPaymentResponse);
//        if (valid.containsValue(0)) {
//            billPaymentResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            billPaymentResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            billPaymentResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            billPaymentResponse.setBillInfo(processBillPaymentInfo(paymentRequest.getPayeeId()));
//            return billPaymentResponse;
//        }
//        billPaymentResponse.setResponseCode((Integer) valid.get("code"));
//        billPaymentResponse.setResponseStatus("Failed");
//        billPaymentResponse.setResponseMessage((String) valid.get("msg"));
//
//        return billPaymentResponse;
//    }
//
//    public CardTransferResponse doCardTransfer(CardTransferRequest cardTransferRequest) {
//        CardTransferResponse cardTransferResponse = new CardTransferResponse();
//        Map<Object, Object> valid = isCardTransferAppIdValid(applicationRepo).and(isCardTransferIpinValid(cardRepo)).and(isCardTransferUuidValid()).and(isTransferPaymentMethodValid(cardRepo)).apply(cardTransferRequest);
//        ebsMapper.cardTransferMapper(cardTransferRequest, cardTransferResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(cardTransferRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//            cardTransferResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            cardTransferResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            cardTransferResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            cardTransferResponse.setBalance(balance);
//            cardTransferResponse.setAcqTranFee(0L);
//            cardTransferResponse.setIssuerTranFee(0L);
//            cardTransferResponse.setToAccount("110190457501869640");
//            cardTransferResponse.setFromAccount("110190457501869640");
//            cardTransferResponse.setAccountCurrency("SDG");
//        }
//        cardTransferResponse.setResponseCode((Integer) valid.get("code"));
//        cardTransferResponse.setResponseStatus("Failed");
//        cardTransferResponse.setResponseMessage((String) valid.get("msg"));
//        return cardTransferResponse;
//    }
//
//    public EchoTestResponse isAlive(EchoTestRequest echoTestRequest) {
//        EchoTestResponse echoTestResponse = new EchoTestResponse();
//        Map<Object, Object> valid = isEchoTestAppIdValid(applicationRepo).and(isEchoTestUuidValid()).apply(echoTestRequest);
//        ebsMapper.isAliveMapper(echoTestRequest, echoTestResponse);
//        if (valid.containsValue(0)) {
//            echoTestResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            echoTestResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            echoTestResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//        }
//        echoTestResponse.setResponseCode((Integer) valid.get("code"));
//        echoTestResponse.setResponseStatus((String) valid.get("status"));
//        echoTestResponse.setResponseMessage((String) valid.get("msg"));
//        return echoTestResponse;
//    }
//
//    public PayeesListResponse getPayeesList(PayeesListRequest payeesListRequest) {
//        PayeesListResponse payeesListResponse = new PayeesListResponse();
//        Map<Object, Object> valid = isAppIdValid(applicationRepo).and(isGetPayeesUuidValid()).apply(payeesListRequest);
//        ebsMapper.payeesListMapper(payeesListRequest, payeesListResponse);
//        if (valid.containsValue(0)) {
//            payeesListResponse.setPayees(payeesRepo.findAll());
//            payeesListResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            payeesListResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            payeesListResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//        }
//        payeesListResponse.setResponseCode((Integer) valid.get("code"));
//        payeesListResponse.setResponseStatus((String) valid.get("status"));
//        payeesListResponse.setResponseMessage((String) valid.get("msg"));
//
//
//        return payeesListResponse;
//    }
//
//    public ChangeIPinResponse changeIPin(ChangeIPinRequest changeIPinRequest) {
//        ChangeIPinResponse changeIPinResponse = new ChangeIPinResponse();
//        Map<Object, Object> valid = isChangeIPINAppIdValid(applicationRepo).and(isChangeIpinValid(cardRepo)).and(isChangeNewIpinValid(cardRepo)).and(isChangeIPINUuidValid()).and(isChabgeIpinPaymentMethodValid(cardRepo)).apply(changeIPinRequest);
//        ebsMapper.changeIpinMapper(changeIPinRequest, changeIPinResponse);
//        if (valid.containsValue(0)) {
//            changeIPinResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            changeIPinResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            changeIPinResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        changeIPinResponse.setResponseCode((Integer) valid.get("code"));
//        changeIPinResponse.setResponseStatus((String) valid.get("status"));
//        changeIPinResponse.setResponseMessage((String) valid.get("msg"));
//        return changeIPinResponse;
//    }
//
//    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
//        ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
//        Map<Object, Object> valid = isChangePasswordUuidValid().and(isChangePasswordIpinValid(cardRepo)).and(isChangePasswordAppIdValid(applicationRepo)).apply(changePasswordRequest);
//        ebsMapper.changePasswordMapper(changePasswordRequest, changePasswordResponse);
//        if (valid.containsValue(0)) {
//            changePasswordResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            changePasswordResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            changePasswordResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        changePasswordResponse.setResponseCode((Integer) valid.get("code"));
//        changePasswordResponse.setResponseStatus((String) valid.get("status"));
//        changePasswordResponse.setResponseMessage((String) valid.get("msg"));
//        return changePasswordResponse;
//    }
//
//    public ForgetPasswordResponse forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
//        ForgetPasswordResponse forgetPasswordResponse = new ForgetPasswordResponse();
//        Map<Object, Object> valid = isForgetPasswordAppIdValid(applicationRepo).and(isForgetPasswordUuidValid()).apply(forgetPasswordRequest);
//        ebsMapper.forgetPasswordMapper(forgetPasswordRequest, forgetPasswordResponse);
//        if (valid.containsValue(0)) {
//            forgetPasswordResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            forgetPasswordResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            forgetPasswordResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        forgetPasswordResponse.setResponseCode((Integer) valid.get("code"));
//        forgetPasswordResponse.setResponseStatus((String) valid.get("status"));
//        forgetPasswordResponse.setResponseMessage((String) valid.get("msg"));
//        return forgetPasswordResponse;
//    }
//
//    public AdminResetPasswordResponse adminResetPassword(AdminResetPaaswordRequest adminResetPaaswordRequest) {
//        AdminResetPasswordResponse adminResetPasswordResponse = new AdminResetPasswordResponse();
//        Map<Object, Object> valid = isAdminResetPasswordAppIdValid(applicationRepo).and(isAdminResetPasswordUuidValid()).apply(adminResetPaaswordRequest);
//        ebsMapper.adminResetPasswordMapper(adminResetPaaswordRequest, adminResetPasswordResponse);
//        if (valid.containsValue(0)) {
//            adminResetPasswordResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            adminResetPasswordResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            adminResetPasswordResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        adminResetPasswordResponse.setResponseCode((Integer) valid.get("code"));
//        adminResetPasswordResponse.setResponseStatus((String) valid.get("status"));
//        adminResetPasswordResponse.setResponseMessage((String) valid.get("msg"));
//        return adminResetPasswordResponse;
//    }
//
//    public GenerateVoucherResponse generateVoucher(GenerateVoucherRequest generateVoucherRequest) {
//        GenerateVoucherResponse generateVoucherResponse = new GenerateVoucherResponse();
//        Map<Object, Object> valid = isGenerateVoucherUuidValid().and(isGenerateVoucehrIpinValid(cardRepo)).and(isGenerateVoucherAppIdValid(applicationRepo)).apply(generateVoucherRequest);
//        ebsMapper.voucherMapper(generateVoucherRequest, generateVoucherResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(generateVoucherRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            generateVoucherResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            generateVoucherResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            generateVoucherResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            generateVoucherResponse.setBalance(balance);
//            generateVoucherResponse.setAcqTranFee(0L);
//            generateVoucherResponse.setIssuerTranFee(0L);
//            generateVoucherResponse.setFromAccount("110190457501869640");
//            generateVoucherResponse.setAccountCurrency("SDG");
//            generateVoucherResponse.setVoucherCode("066783");
//        }
//        generateVoucherResponse.setResponseCode((Integer) valid.get("code"));
//        generateVoucherResponse.setResponseStatus((String) valid.get("status"));
//        generateVoucherResponse.setResponseMessage((String) valid.get("msg"));
//        return generateVoucherResponse;
//    }
//
//    public ServicePaymentResponse specialPayment(ServicePaymentRequest servicePaymentRequest) {
//        ServicePaymentResponse servicePaymentResponse = new ServicePaymentResponse();
//        Map<Object, Object> valid = isSpecialPaymentUuidValid().and(isSpecialPaymentIpinValid(cardRepo)).and(isSpecialPaymentAppIdValid(applicationRepo)).apply(servicePaymentRequest);
//        ebsMapper.specialPaymentMapper(servicePaymentRequest, servicePaymentResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(servicePaymentRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            servicePaymentResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            servicePaymentResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            servicePaymentResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            servicePaymentResponse.setBalance(balance);
//            servicePaymentResponse.setAcqTranFee(0L);
//            servicePaymentResponse.setIssuerTranFee(0L);
//            servicePaymentResponse.setFromAccount("110190457501869640");
//            servicePaymentResponse.setAccountCurrency("SDG");
//        }
//        servicePaymentResponse.setResponseCode((Integer) valid.get("code"));
//        servicePaymentResponse.setResponseStatus((String) valid.get("status"));
//        servicePaymentResponse.setResponseMessage((String) valid.get("msg"));
//        return servicePaymentResponse;
//    }
//
//    public TransactionStatusResponse getTransactionStatus(TransactionStatusRequest transactionStatusRequest) {
//        TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
//        Map<Object, Object> valid = isTransactionStatusOriginalUuidValid().and(isTransactionStatusUuidValid()).and(isTransactionStatusAppIdValid(applicationRepo)).apply(transactionStatusRequest);
//        ebsMapper.transactionStatusMapper(transactionStatusRequest, transactionStatusResponse);
//        if (valid.containsValue(0)) {
//            transactionStatusResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            transactionStatusResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            transactionStatusResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            transactionStatusResponse.setOriginalTransaction(valid);
//            transactionStatusResponse.setOriginalTranType("");
//        }
//        transactionStatusResponse.setResponseCode((Integer) valid.get("code"));
//        transactionStatusResponse.setResponseStatus((String) valid.get("status"));
//        transactionStatusResponse.setResponseMessage((String) valid.get("msg"));
//        return transactionStatusResponse;
//    }
//
//    public UpdateCardRegistrationResponse updateRegisteredCard(UpdateCardRegistrationRequest updateCardRegistrationRequest) {
//        UpdateCardRegistrationResponse updateCardRegistrationResponse = new UpdateCardRegistrationResponse();
//        ebsMapper.updateCardMapper(updateCardRegistrationRequest, updateCardRegistrationResponse);
//        if (true) {
//            updateCardRegistrationResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            updateCardRegistrationResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            updateCardRegistrationResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        return updateCardRegistrationResponse;
//    }
//
//    public AccountTransferResponse doAccountTransfer(AccountTransferRequest accountTransferRequest) {
//        AccountTransferResponse accountTransferResponse = new AccountTransferResponse();
//        Map<Object, Object> valid = isAccountTransferUuidValid().and(isAccountTransferIpinValid(cardRepo)).and(isAccountTransferAppIdValid(applicationRepo)).apply(accountTransferRequest);
//        ebsMapper.accountTransferMapper(accountTransferRequest, accountTransferResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(accountTransferRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            accountTransferResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            accountTransferResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            accountTransferResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            accountTransferResponse.setFromAccount("110190457501869640");
//            accountTransferResponse.setBalance(balance);
//            accountTransferResponse.setAcqTranFee(0L);
//            accountTransferResponse.setIssuerTranFee(0L);
//            accountTransferResponse.setAccountCurrency("SDG");
//        }
//        accountTransferResponse.setResponseCode((Integer) valid.get("code"));
//        accountTransferResponse.setResponseStatus((String) valid.get("status"));
//        accountTransferResponse.setResponseMessage((String) valid.get("msg"));
//        return accountTransferResponse;
//    }
//
//    public MerchantRegistrationResponse doMerchantsRegistration(MerchantRegistrationRequest merchantRegistrationRequest) {
//        MerchantRegistrationResponse merchantRegistrationResponse = new MerchantRegistrationResponse();
//        Map<Object, Object> valid = isMerchantRegistrationUuidValid().and(isMerchantRegistrationAppIdValid(applicationRepo)).apply(merchantRegistrationRequest);
//        ebsMapper.merchantRegistrationMapper(merchantRegistrationRequest, merchantRegistrationResponse);
//        if (valid.containsValue(0)) {
//            merchantRegistrationResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            merchantRegistrationResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            merchantRegistrationResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            merchantRegistrationResponse.setMerchantID(merchantRegistrationRequest.getIdNo());
//            merchantRegistrationResponse.setGeneratedQR("hw9384TY984YGHUIGUVHOR89A");
//        }
//        merchantRegistrationResponse.setResponseCode((Integer) valid.get("code"));
//        merchantRegistrationResponse.setResponseStatus((String) valid.get("status"));
//        merchantRegistrationResponse.setResponseMessage((String) valid.get("msg"));
//        return merchantRegistrationResponse;
//    }
//
//    public QrPurchaseResponse doQRPurchase(QrPurchaseRequest qrPurchaseRequest) {
//        QrPurchaseResponse qrPurchaseResponse = new QrPurchaseResponse();
//        Map<Object, Object> valid = isQRPurchaseUuidValid().and(isQRPurchaseIpinValid(cardRepo)).and(isQRPurchaseAppIdValid(applicationRepo)).and(isPurchasePaymentMethodValid(cardRepo)).apply(qrPurchaseRequest);
//        ebsMapper.qrPurchaseMapper(qrPurchaseRequest, qrPurchaseResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(qrPurchaseRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            qrPurchaseResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            qrPurchaseResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            qrPurchaseResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            qrPurchaseResponse.setToAccountType("");
//            qrPurchaseResponse.setBalance(balance);
//            qrPurchaseResponse.setAcqTranFee(0L);
//            qrPurchaseResponse.setIssuerTranFee(0L);
//            qrPurchaseResponse.setToAccount("");
//            qrPurchaseResponse.setFromAccount("");
//            qrPurchaseResponse.setAccountCurrency("SDG");
//            qrPurchaseResponse.setTransactionId("9720953");
//        }
//        qrPurchaseResponse.setResponseCode((Integer) valid.get("code"));
//        qrPurchaseResponse.setResponseStatus((String) valid.get("status"));
//        qrPurchaseResponse.setResponseMessage((String) valid.get("msg"));
//        return qrPurchaseResponse;
//    }
//
//    public QrRefundResponse doQRRefund(QrRefundRequest qrRefundRequest) {
//        QrRefundResponse qrRefundResponse = new QrRefundResponse();
//        Map<Object, Object> valid = isQRRefundAppIdValid(applicationRepo).and(isQRRefundIpinValid(cardRepo)).and(isQRRefundUuidValid()).and(isRefundPaymentMethodValid(cardRepo)).apply(qrRefundRequest);
//        ebsMapper.qrRefundMapper(qrRefundRequest, qrRefundResponse);
//        if (valid.containsValue(0)) {
//            qrRefundResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            qrRefundResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            qrRefundResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            qrRefundResponse.setTranCurrency("SDG");
//            qrRefundResponse.setTranAmount(0L);
//            qrRefundResponse.setAcqTranFee(0L);
//            qrRefundResponse.setIssuerTranFee(0L);
//        }
//        qrRefundResponse.setResponseCode((Integer) valid.get("code"));
//        qrRefundResponse.setResponseStatus((String) valid.get("status"));
//        qrRefundResponse.setResponseMessage((String) valid.get("msg"));
//        return qrRefundResponse;
//    }
//
//    public MerchantTransactionStatusResponse getMerchantTransactions(MerchantTransactionStatusRequest merchantTransactionStatusRequest) {
//        MerchantTransactionStatusResponse merchantTransactionStatusResponse = new MerchantTransactionStatusResponse();
//        Map<Object, Object> valid = isMerchantTransactionsUuidValid().and(isMerchantTransactionsIpinValid(cardRepo)).and(isMerchantTransactionsAppIdValid(applicationRepo)).apply(merchantTransactionStatusRequest);
//        ebsMapper.merchantTransactionsMapper(merchantTransactionStatusRequest, merchantTransactionStatusResponse);
//        if (valid.containsValue(0)) {
//            merchantTransactionStatusResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            merchantTransactionStatusResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            merchantTransactionStatusResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            merchantTransactionStatusResponse.setLastTransactions(null);
//        }
//        merchantTransactionStatusResponse.setResponseCode((Integer) valid.get("code"));
//        merchantTransactionStatusResponse.setResponseStatus((String) valid.get("status"));
//        merchantTransactionStatusResponse.setResponseMessage((String) valid.get("msg"));
//        return merchantTransactionStatusResponse;
//    }
//
//    public InquirePanResponse checkMsisdnAganistPAN(InquirePanRequest inquirePanRequest) {
//        InquirePanResponse inquirePanResponse = new InquirePanResponse();
//        Map<Object, Object> valid = isInquirePanAppIdValid(applicationRepo).and(isInquirePanUuidValid()).apply(inquirePanRequest);
//        ebsMapper.inquirePanMapper(inquirePanRequest, inquirePanResponse);
//        if (valid.containsValue(0)) {
//            inquirePanResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            inquirePanResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            inquirePanResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//        }
//        inquirePanResponse.setResponseCode((Integer) valid.get("code"));
//        inquirePanResponse.setResponseStatus((String) valid.get("status"));
//        inquirePanResponse.setResponseMessage((String) valid.get("msg"));
//        return inquirePanResponse;
//    }
//
//    public CompleteTransactionResponse completeTransaction(CompleteTransactionRequest completeTransactionRequest) {
//        CompleteTransactionResponse completeTransactionResponse = new CompleteTransactionResponse();
//        Map<Object, Object> valid = isCompleteTransactionUuidValid().and(isCompleteTransactionAppIdValid(applicationRepo)).apply(completeTransactionRequest);
//        ebsMapper.completeTransactionMapper(completeTransactionRequest, completeTransactionResponse);
//        if (valid.containsValue(0)) {
//            completeTransactionResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            completeTransactionResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            completeTransactionResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            completeTransactionResponse.setUserName("");
//            completeTransactionResponse.setEntityId("");
//            completeTransactionResponse.setEntityType("");
//            completeTransactionResponse.setEntityGroup("");
//            completeTransactionResponse.setPan("");
//            completeTransactionResponse.setMbr("");
//            completeTransactionResponse.setPhoneNo("");
//            completeTransactionResponse.setEmail("");
//            completeTransactionResponse.setFinancialInstitutionId("");
//            completeTransactionResponse.setRegistrationType("");
//            completeTransactionResponse.setOriginalTranUUID("");
//            completeTransactionResponse.setExpDate("");
//            completeTransactionResponse.setPanCategory("");
////            completeTransactionResponse.setExtraInfo();
//        }
//        completeTransactionResponse.setResponseCode((Integer) valid.get("code"));
//        completeTransactionResponse.setResponseStatus((String) valid.get("status"));
//        completeTransactionResponse.setResponseMessage((String) valid.get("msg"));
//        return completeTransactionResponse;
//    }
//
//    public GetCustomerInfoResponse getCustomerInfo(GetCustomerInfoRequest getCustomerInfoRequest) {
//        GetCustomerInfoResponse getCustomerInfoResponse = new GetCustomerInfoResponse();
//        Map<Object, Object> valid = isGetCustomerInfoUuidValid().and(isGetCustomerInfoAppIdValid(applicationRepo)).apply(getCustomerInfoRequest);
//        ebsMapper.customerInfoMapper(getCustomerInfoRequest, getCustomerInfoResponse);
//        if (valid.containsValue(0)) {
//            getCustomerInfoResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            getCustomerInfoResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            getCustomerInfoResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            getCustomerInfoResponse.setPan(getCustomerInfoRequest.getPan());
//            getCustomerInfoResponse.setName("Mike");
//            getCustomerInfoResponse.setBank("Bank of Khartoum");
//            getCustomerInfoResponse.setCardType("Cash Card");
//        }
//        getCustomerInfoResponse.setResponseCode((Integer) valid.get("code"));
//        getCustomerInfoResponse.setResponseStatus((String) valid.get("status"));
//        getCustomerInfoResponse.setResponseMessage((String) valid.get("msg"));
//        return getCustomerInfoResponse;
//    }
//
//    public DoCashInResponse doCashIn(DoCashInRequest doCashInRequest) {
//        DoCashInResponse doCashInResponse = new DoCashInResponse();
//        Map<Object, Object> valid = isCashINUuidValid().and(isCashINIpinValid(cardRepo)).and(isCashINAppIdValid(applicationRepo)).and(isCashInPaymentMethodValid(cardRepo)).apply(doCashInRequest);
//        ebsMapper.cashInMapper(doCashInRequest, doCashInResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(doCashInRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            doCashInResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            doCashInResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            doCashInResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            doCashInResponse.setBalance(balance);
//            doCashInResponse.setAcqTranFee(0L);
//            doCashInResponse.setIssuerTranFee(0L);
//            doCashInResponse.setToAccount("");
//            doCashInResponse.setFromAccount("");
//            doCashInResponse.setAccountCurrency("SDG");
//        }
//        doCashInResponse.setResponseCode((Integer) valid.get("code"));
//        doCashInResponse.setResponseStatus((String) valid.get("status"));
//        doCashInResponse.setResponseMessage((String) valid.get("msg"));
//        return doCashInResponse;
//    }
//
//    public DoCashOutResponse doCashOut(DoCashOutRequest doCashOutRequest) {
//        DoCashOutResponse doCashOutResponse = new DoCashOutResponse();
//        Map<Object, Object> valid = isCashOUTUuidValid().and(isCashOUTeIpinValid(cardRepo)).and(isCashOUTAppIdValid(applicationRepo)).and(isCashOutPaymentMethodValid(cardRepo)).apply(doCashOutRequest);
//        ebsMapper.cashOutMapper(doCashOutRequest, doCashOutResponse);
//        if (valid.containsValue(0)) {
//            Map<String, Object> balance = new HashMap<>();
//            Optional<Card> card = cardRepo.findByPan(doCashOutRequest.getPan());
//            balance.put("available", card.get().getBalance());
//            balance.put("leger", card.get().getBalance());
//
//            doCashOutResponse.setResponseCode(Constant.ResponseCode.Success.code);
//            doCashOutResponse.setResponseMessage(Constant.ResponseCode.Success.msg);
//            doCashOutResponse.setResponseStatus(Constant.ResponseCode.Success.status);
//            doCashOutResponse.setBalance(balance);
//            doCashOutResponse.setAcqTranFee(0L);
//            doCashOutResponse.setIssuerTranFee(0L);
//            doCashOutResponse.setToAccount("");
//            doCashOutResponse.setFromAccount("");
//            doCashOutResponse.setAccountCurrency("SDG");
//        }
//        doCashOutResponse.setResponseCode((Integer) valid.get("code"));
//        doCashOutResponse.setResponseStatus((String) valid.get("status"));
//        doCashOutResponse.setResponseMessage((String) valid.get("msg"));
//        return doCashOutResponse;
//    }
//
//    public GetFileEncryptionResponse getFileEncryptionKey(GetFileEncryptionRequest getFileEncryptionRequest) {
//        return null;
//    }

//    private Map<String, Object> processBillInquiryInfo(String payeeId) {
//        Map<String, Object> billInfo = new HashMap<>();
//        switch (payeeId) {
//            case "0010010001":
//            case "0010010003":
//            case "0010010005":
//            case "0010020001":
//            case "0010017801":
//            case "0010060005":
//            case "0010060004":
//                break;
//            case "0010010002":
//                billInfo.put("contractNumber", "9790432");
//                billInfo.put("unbilledAmount", "99.0");
//                billInfo.put("totalAmount", "199.0");
//                billInfo.put("lastInvoiceDate", "20/01/2022");
//                billInfo.put("last4Digits", "0432");
//                billInfo.put("billedAmount", "100.00");
//                break;
//            case "0010010004":
//                billInfo.put("contractNumber", "9790432");
//                billInfo.put("unbilledAmount", "99.0");
//                billInfo.put("total", "199.0");
//                billInfo.put("lastInvoiceDate", "20/01/2022");
//                billInfo.put("billedAmount", "100.00");
//                break;
//            case "0010010006":
//                billInfo.put("SubscriberID", "9790432");
//                billInfo.put("billAmount", "100.00");
//                break;
//            case "0010030002":
//                billInfo.put("formNo", "89731");
//                billInfo.put("receiptNo", "9872986");
//                billInfo.put("englishName", "Ahmed Tahir");
//                billInfo.put("arabicName", "احمد طاهر");
//                billInfo.put("dueAmount", "100.00");
//                break;
//            case "0010030003":
//                billInfo.put("BankCode", "9790432");
//                billInfo.put("DeclarantCode ", "99.0");
//                billInfo.put("Amount", "199.0");
//                billInfo.put("ProcStatus", "20/01/2022");
//                billInfo.put("ProcError", "100.00");
//                billInfo.put("RegistrationNumber", "199.0");
//                billInfo.put("RegistrationSerial", "20/01/2022");
//                billInfo.put("Year", "2024");
//                billInfo.put("AmountToBePaid", "20/01/2022");
//                billInfo.put("Status", "2024");
//                break;
//            case "0010030004":
//                billInfo.put("formNo", "9790432");
//                billInfo.put("receiptNo ", "99.0");
//                billInfo.put("englishName", "199.0");
//                billInfo.put("arabicName", "20/01/2022");
//                billInfo.put("studentNo", "100.00");
//                billInfo.put("dueAmount", "199.0");
//                break;
//            case "0010050001":
//                billInfo.put("ReferenceId", "9790432");
//                billInfo.put("UnitName ", "99.0");
//                billInfo.put("ServiceName", "199.0");
//                billInfo.put("PayerName", "20/01/2022");
//                billInfo.put("TotalAmount", "100.00");
//                billInfo.put("DueAmount", "199.0");
//                billInfo.put("InvoiceExpiry", "100.00");
//                billInfo.put("InvoiceStatus", "199.0");
//                break;
//            case "0010060002":
//                billInfo.put("CustomerName", "100.00");
//                billInfo.put("BashaerCardStatus", "199.0");
//                break;
//            case "0010060003":
//                billInfo.put("ServiceDueDate", "100.00");
//                billInfo.put("ServiceDetails", "199.0");
//                billInfo.put("ServiceDueAmount", "100.00");
//                billInfo.put("ServiceTotalAmount", "199.0");
//                break;
//            case "0055555555":
//                billInfo.put("invoice_status", "0");
//                billInfo.put("amount_due", "199.0");
//                billInfo.put("service_provider", "0055555555");
//                billInfo.put("verifier", "987169");
//                billInfo.put("ref_id", "10.0");
//                billInfo.put("minAmount", "10.0");
//                break;
//            case "0055555556":
//                billInfo.put("invoice_status", "0");
//                billInfo.put("amount_due", "199.0");
//                billInfo.put("service_provider", "100.00");
//                billInfo.put("payer_name", "Mohamed Mussa");
//                billInfo.put("minAmount", "10.0");
//                break;
//        }
//        return billInfo;
//    }
//
//    private Map<String, Object> processBillPaymentInfo(String payeeId) {
//        Map<String, Object> billInfo = new HashMap<>();
//        switch (payeeId) {
//            case "0010010001":
//            case "0010017801":
//            case "0010060005":
//            case "0010060004":
//            case "0010010004":
//                break;
//            case "0010010002":
//                billInfo.put("receiptNo", "9790432");
//                break;
//            case "0010010003":
//                billInfo.put("subNewBalance", "100.00");
//                break;
//            case "0010010005":
//            case "0010010006":
//                billInfo.put("SubscriberID", "9790432");
//                billInfo.put("billAmount", "100.00");
//                break;
//            case "0010020001":
//                billInfo.put("meterFees", "9790432");
//                billInfo.put("netAmount", "100.00");
//                billInfo.put("customerName", "9790432");
//                billInfo.put("accountNo", "100.00");
//                billInfo.put("meterNumber", "9790432");
//                billInfo.put("token", "100.00");
//                billInfo.put("unitsInKWh", "9790432");
//                billInfo.put("waterFees", "100.00");
//                billInfo.put("opertorMessage", "9790432");
//                break;
//            case "0010030002":
//                billInfo.put("formNo", "89731");
//                billInfo.put("receiptNo", "9872986");
//                billInfo.put("englishName", "Ahmed Tahir");
//                billInfo.put("arabicName", "احمد طاهر");
//                break;
//            case "0010030003":
//                billInfo.put("BankCode", "9790432");
//                billInfo.put("DeclarantCode ", "99.0");
//                billInfo.put("Amount", "199.0");
//                billInfo.put("ProcStatus", "20/01/2022");
//                billInfo.put("ProcError", "100.00");
//                billInfo.put("ReceiptNumber", "199.0");
//                billInfo.put("ReceiptSerial", "20/01/2022");
//                billInfo.put("ReceiptDate", "2024");
//                billInfo.put("Status", "20/01/2022");
//                billInfo.put("E-15ReceiptNumber", "2024");
//                break;
//            case "0010030004":
//                billInfo.put("formNo", "9790432");
//                billInfo.put("receiptNo ", "99.0");
//                billInfo.put("englishName", "199.0");
//                billInfo.put("arabicName", "20/01/2022");
//                billInfo.put("studentNo", "6356");
//                break;
//            case "0010050001":
//                billInfo.put("ReferenceId", "9790432");
//                billInfo.put("UnitName ", "99.0");
//                billInfo.put("ServiceName", "199.0");
//                billInfo.put("PayerName", "20/01/2022");
//                billInfo.put("TotalAmount", "100.00");
//                break;
//            case "0010060002":
//                billInfo.put("CustomerName", "100.00");
//                break;
//            case "0010060003":
//                billInfo.put("ServiceName", "100.00");
//                billInfo.put("ServiceDetails", "199.0");
//                break;
//            case "0055555555":
//                billInfo.put("invoice_status", "0");
//                billInfo.put("amount_due", "199.0");
//                billInfo.put("service_provider", "0055555555");
//                billInfo.put("verifier", "987169");
//                billInfo.put("ref_id", "10.0");
//                billInfo.put("minAmount", "10.0");
//                break;
//            case "0055555556":
//                billInfo.put("invoice_status", "0");
//                billInfo.put("amount_due", "199.0");
//                billInfo.put("service_provider", "100.00");
//                billInfo.put("minAmount", "10.0");
//                break;
//        }
//        return billInfo;
//    }
//
}
