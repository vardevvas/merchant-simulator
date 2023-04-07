package com.goal.merchantsimulator.service;

import com.goal.merchantsimulator.dto.inbound.*;
import com.goal.merchantsimulator.dto.outbound.*;
import com.goal.merchantsimulator.mapper.EbsMapper;
import com.goal.merchantsimulator.repository.TerminalRepo;
import com.goal.merchantsimulator.repository.CardRepo;
import com.goal.merchantsimulator.repository.PayeesRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.goal.merchantsimulator.Validation.PayeeValidation.isPayeeIdValid;
import static com.goal.merchantsimulator.Validation.DefaultValidation.*;

@Service
@AllArgsConstructor
public class EbsServices {
    private final PayeesRepo payeesRepo;
    private final TerminalRepo terminalRepo;
    private final CardRepo cardRepo;
    private final EbsMapper ebsMapper;
    private final CardService cardService;

    public PurchaseResponse purchase(PurchaseRequest request) {
        PurchaseResponse response = new PurchaseResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public PurchaseMobileResponse purchaseMobile(PurchaseMobileRequest request) {
        PurchaseMobileResponse response = new PurchaseMobileResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseMobileMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public PurchaseWithCashBackResponse purchaseWithCashBack(PurchaseWithCashBackRequest request) {
        PurchaseWithCashBackResponse response = new PurchaseWithCashBackResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseWithCashBackMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public ReversalResponse reverse(ReversalRequest request) {
        ReversalResponse response = new ReversalResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.reverseBackMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public MiniStatementResponse GetMiniStatement(MiniStatementRequest request) {
        MiniStatementResponse response = new MiniStatementResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.GetMiniStatementMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public BillInquiryResponse getBillInquiry(BillInquiryRequest request) {
        BillInquiryResponse response = new BillInquiryResponse();
        ebsMapper.getBillInquiryMapper(request, response);
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        valid = valid.containsValue(0)? isPayeeIdValid().apply(request) : valid;
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BillPrepaymentResponse billPrepayment(BillPrepaymentRequest request) {
        BillPrepaymentResponse response = new BillPrepaymentResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.billPrepaymentMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BillPaymentResponse billPayment(BillPaymentRequest request) {
        BillPaymentResponse response = new BillPaymentResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.billPaymentMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BalanceInquiryResponse balanceInquiry(BalanceInquiryRequest request) {
        BalanceInquiryResponse response = new BalanceInquiryResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.balanceInquiryMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public PINChangeResponse changePIN(PINChangeRequest request) {
        PINChangeResponse response = new PINChangeResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.changePINMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CashInResponse cashIn(CashInRequest request) {
        CashInResponse response = new CashInResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.cashInMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public RefundResponse refund(RefundRequest request) {
        RefundResponse response = new RefundResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.refundMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public GenerateVoucherResponse generateVoucher(GenerateVoucherRequest request) {
        GenerateVoucherResponse response = new GenerateVoucherResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.generateVoucherMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CashOutVoucherResponse cashOutVoucher(CashOutVoucherRequest request) {
        CashOutVoucherResponse response = new CashOutVoucherResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.cashOutVoucherMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CardTransferResponse cardTransfer(CardTransferRequest request) {
        CardTransferResponse response = new CardTransferResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.cardTransferMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public AccountTransferResponse accountTransfer(AccountTransferRequest request) {
        AccountTransferResponse response = new AccountTransferResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        valid = valid.containsValue(0)? cardService.isPanValid(request.getPan(),request.getExpDate(), valid) : valid;
        ebsMapper.accountTransferMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public VoucherCashInResponse voucherCashIn(VoucherCashInRequest request) {
        VoucherCashInResponse response = new VoucherCashInResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.voucherCashInMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public GeneralResponse networkTest(DefaultRequest request) {
        GeneralResponse response = new GeneralResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.networkTestMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public PayeesListResponse payeesList(DefaultRequest request) {
        PayeesListResponse response = new PayeesListResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.payeesListMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public WorkingKeyResponse workingKey(DefaultRequest request) {
        WorkingKeyResponse response = new WorkingKeyResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.workingKeyMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CashOutResponse cashOut(CashOutRequest request) {
        CashOutResponse response = new CashOutResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.cashOutMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public TransactionStatusResponse transactionStatus(TransactionStatusRequest request) {
        TransactionStatusResponse response = new TransactionStatusResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.transactionStatusMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public VoidPurchaseResponse voidPurchase(VoidPurchaseRequest request) {
        VoidPurchaseResponse response = new VoidPurchaseResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.voidPurchaseMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CompleteTransactionResponse completeTransaction(DefaultRequest request) {
        CompleteTransactionResponse response = new CompleteTransactionResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.completeTransactionMapper(request, response);
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }
}
