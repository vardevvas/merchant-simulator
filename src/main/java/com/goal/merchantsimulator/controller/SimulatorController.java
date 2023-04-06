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


}
