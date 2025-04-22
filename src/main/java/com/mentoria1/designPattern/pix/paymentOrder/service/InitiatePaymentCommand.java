package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;

//Representa o que faz um command de criação
public interface InitiatePaymentCommand {
    public PaymentOrder execute();
}
