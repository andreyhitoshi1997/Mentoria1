package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentInitiationMethod;
import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;

import java.math.BigDecimal;

public class QrCodeInitiatePaymentCommand implements InitiatePaymentCommand{

    final private String brCode;

    public QrCodeInitiatePaymentCommand(String brCode) {
        this.brCode = brCode;
    }

    public PaymentOrder execute(){
        System.out.println("Crate payment by QrCode " + this.brCode);
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setAmount(new BigDecimal(500));
        paymentOrder.setInitiationMethod(PaymentInitiationMethod.QR_CODE);
        return paymentOrder;
    }
}
