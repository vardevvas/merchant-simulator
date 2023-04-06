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

    @PostMapping("/getBill")
    public ResponseEntity<BillInquiryResponse> getBillInquiry(@Validated @RequestBody BillInquiryRequest request) {
        return new ResponseEntity<>(ebsServices.getBillInquiry(request), HttpStatus.OK);

    }

    @PostMapping("/payBill")
    public ResponseEntity<BillPaymentResponse> billPrepayment(@Validated @RequestBody BillPaymentRequest request) {
        return new ResponseEntity<>(ebsServices.billPayment(request), HttpStatus.OK);

    }

    @PostMapping("/prepayBill")
    public ResponseEntity<BillPrepaymentResponse> billPrepayment(@Validated @RequestBody BillPrepaymentRequest request) {
        return new ResponseEntity<>(ebsServices.billPrepayment(request), HttpStatus.OK);

    }

    @PostMapping("/getBalance")
    public ResponseEntity<BalanceInquiryResponse> balanceInquiry(@Validated @RequestBody BalanceInquiryRequest request) {
        return new ResponseEntity<>(ebsServices.balanceInquiry(request), HttpStatus.OK);

    }

    @PostMapping("/changePin")
    public ResponseEntity<PINChangeResponse> changePIN(@Validated @RequestBody PINChangeRequest request) {
        return new ResponseEntity<>(ebsServices.changePIN(request), HttpStatus.OK);

    }

    @PostMapping("/cashIn")
    public ResponseEntity<CashInResponse> cashIn(@Validated @RequestBody CashInRequest request) {
        return new ResponseEntity<>(ebsServices.cashIn(request), HttpStatus.OK);

    }

    @PostMapping("/refund")
    public ResponseEntity<RefundResponse> refund(@Validated @RequestBody RefundRequest request) {
        return new ResponseEntity<>(ebsServices.refund(request), HttpStatus.OK);

    }

    @PostMapping("/generateVoucher")
    public ResponseEntity<GenerateVoucherResponse> generateVoucher(@Validated @RequestBody GenerateVoucherRequest request) {
        return new ResponseEntity<>(ebsServices.generateVoucher(request), HttpStatus.OK);

    }

}
