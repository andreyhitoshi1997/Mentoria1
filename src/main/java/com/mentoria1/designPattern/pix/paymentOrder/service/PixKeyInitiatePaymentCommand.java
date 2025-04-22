package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentInitiationMethod;
import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;

import java.math.BigDecimal;

public class PixKeyInitiatePaymentCommand implements InitiatePaymentCommand {
    final private String pixKey;
    final private BigDecimal amount;

    public PixKeyInitiatePaymentCommand(String pixKey, BigDecimal amount) {
        this.pixKey = pixKey;
        this.amount = amount;
    }

    public PaymentOrder execute() {
        System.out.println("Creating payment By pixKey: " + this.pixKey);
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setAmount(this.amount);
        paymentOrder.setInitiationMethod(PaymentInitiationMethod.PIX_KEY);
        return paymentOrder;
    }
}
