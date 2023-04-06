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

@Service
@AllArgsConstructor
public class EbsServices {
    private final PayeesRepo payeesRepo;
    private final TerminalRepo terminalRepo;
    private final CardRepo cardRepo;
    private final EbsMapper ebsMapper;

    public PurchaseResponse purchase(PurchaseRequest request) {
        PurchaseResponse response = new PurchaseResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public PurchaseMobileResponse purchaseMobile(PurchaseMobileRequest request) {
        PurchaseMobileResponse response = new PurchaseMobileResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseMobileMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public PurchaseWithCashBackResponse purchaseWithCashBack(PurchaseWithCashBackRequest request) {
        PurchaseWithCashBackResponse response = new PurchaseWithCashBackResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.purchaseWithCashBackMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public ReversalResponse reverse(ReversalRequest request) {
        ReversalResponse response = new ReversalResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.reverseBackMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public MiniStatementResponse GetMiniStatement(MiniStatementRequest request) {
        MiniStatementResponse response = new MiniStatementResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.GetMiniStatementMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;

    }

    public BillInquiryResponse getBillInquiry(BillInquiryRequest request) {
        BillInquiryResponse response = new BillInquiryResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.getBillInquiryMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BillPrepaymentResponse billPrepayment(BillPrepaymentRequest request) {
        BillPrepaymentResponse response = new BillPrepaymentResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.billPrepaymentMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BillPaymentResponse billPayment(BillPaymentRequest request) {
        BillPaymentResponse response = new BillPaymentResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.billPaymentMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public BalanceInquiryResponse balanceInquiry(BalanceInquiryRequest request) {
        BalanceInquiryResponse response = new BalanceInquiryResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.balanceInquiryMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public PINChangeResponse changePIN(PINChangeRequest request) {
        PINChangeResponse response = new PINChangeResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.changePINMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public CashInResponse cashIn(CashInRequest request) {
        CashInResponse response = new CashInResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.cashInMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public RefundResponse refund(RefundRequest request) {
        RefundResponse response = new RefundResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.refundMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }

    public GenerateVoucherResponse generateVoucher(GenerateVoucherRequest request) {
        GenerateVoucherResponse response = new GenerateVoucherResponse();
        Map<Object, Object> valid = isClientIdValid(terminalRepo).and(isTerminalIdValid(terminalRepo)).and(isSystemTraceAuditNumberValid(terminalRepo)).apply(request);
        ebsMapper.generateVoucherMapper(request, response);
        if (valid.containsValue(0)) {
            response.setResponseCode(Constant.ResponseCode.Success.code);
            response.setResponseMessage(Constant.ResponseCode.Success.msg);
            response.setResponseStatus(Constant.ResponseCode.Success.status);
            return response;
        }
        response.setResponseCode((Integer) valid.get("code"));
        response.setResponseMessage((String) valid.get("msg"));
        response.setResponseStatus((String) valid.get("status"));
        return response;
    }
}
