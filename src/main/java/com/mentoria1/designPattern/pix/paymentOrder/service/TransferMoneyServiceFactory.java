package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.repository.PaymentOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferMoneyServiceFactory {
    final private PaymentOrderRepository paymentOrderRepository;

    public TransferMoneyServiceFactory(PaymentOrderRepository paymentOrderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
    }

    public TransferMoneyService getTransferMoneyService(InitiatePaymentCommand command) {
        return new TransferMoneyService(command, this.paymentOrderRepository);
    }
}
