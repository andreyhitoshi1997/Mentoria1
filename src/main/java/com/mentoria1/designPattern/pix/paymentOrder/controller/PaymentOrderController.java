package com.mentoria1.designPattern.pix.paymentOrder.controller;

import com.mentoria1.designPattern.pix.paymentOrder.model.*;
import com.mentoria1.designPattern.pix.paymentOrder.repository.PaymentOrderRepository;
import com.mentoria1.designPattern.pix.paymentOrder.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pix/payment-order")
public class PaymentOrderController {
    final private TransferMoneyServiceFactory transferMoneyServiceFactory;
    final private PaymentOrderRepository paymentOrderRepository;

    public PaymentOrderController(TransferMoneyServiceFactory transferMoneyServiceFactory, PaymentOrderRepository paymentOrderRepository) {
        this.transferMoneyServiceFactory = transferMoneyServiceFactory;
        this.paymentOrderRepository = paymentOrderRepository;
    }

    @GetMapping
    public ResponseEntity<List<PaymentOrder>> getPaymentOrder() {
        return ResponseEntity.ok(this.paymentOrderRepository.findAll());
    }

    @PostMapping("/pix-key")
    public ResponseEntity<PaymentOrder> createPaymentOrder(
            @RequestBody PixKeyPaymentOrderRequest payload) {
        InitiatePaymentCommand command =  new PixKeyInitiatePaymentCommand(payload.getPixKey(), payload.getAmount());
        TransferMoneyService transferMoneyService = this.transferMoneyServiceFactory.getTransferMoneyService(command);
        return ResponseEntity.ok(transferMoneyService.execute());
    }

    @PostMapping("/qr-code")
    public ResponseEntity<PaymentOrder> createPaymentOrderQrCode(
            @RequestBody QrCodePaymentOrderRequest payload) {
        InitiatePaymentCommand command = new QrCodeInitiatePaymentCommand(payload.getBrCode());
        TransferMoneyService transferMoneyService = this.transferMoneyServiceFactory.getTransferMoneyService(command);
        return ResponseEntity.ok(transferMoneyService.execute());
    }

    @PostMapping("/banking-account")
    public ResponseEntity<PaymentOrder> createPaymentOrderBankingAccount(
            @RequestBody BankingAccountPaymentOrderRequest payload) {
        InitiatePaymentCommand command = new BankingAccountInitiatePaymentCommand(payload.getCpf(), payload.getAgency(), payload.getBranchNumber(), payload.getAmount());
        TransferMoneyService transferMoneyService = this.transferMoneyServiceFactory.getTransferMoneyService(command);
        return ResponseEntity.ok(transferMoneyService.execute());
    }
}
