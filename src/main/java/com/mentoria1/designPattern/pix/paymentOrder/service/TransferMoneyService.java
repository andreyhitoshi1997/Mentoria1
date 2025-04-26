package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;
import com.mentoria1.designPattern.pix.paymentOrder.repository.PaymentOrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

public class TransferMoneyService {
    final private InitiatePaymentCommand initiateCommand;
    final private PaymentOrderRepository paymentOrderRepository;

    public TransferMoneyService(InitiatePaymentCommand initiateCommand, PaymentOrderRepository paymentOrderRepository) {
        this.initiateCommand = initiateCommand;
        this.paymentOrderRepository = paymentOrderRepository;
    }

    public PaymentOrder execute(){
        PaymentOrder paymentOrder = this.initiateCommand.execute();
        paymentOrder.setId(UUID.randomUUID());
        paymentOrder.setCreatedAt(Instant.now());
        paymentOrder.setUpdatedAt(Instant.now());
        paymentOrder.setExternalId(UUID.randomUUID().toString());
        this.paymentOrderRepository.save(paymentOrder);
        return paymentOrder;
    }
}

// Tarefa de casa
// Criar o controller que tem que chamar o service no final e passando um command
// api/pix/payment-order/
//Aprender o IntelliJ e usar a versão paga o máximo possível e usar o auto complete ao meu favor
//inicializar a aplicaçõa
//Debug
//Tomar cuidado com typos, tipagem, digitar mais devagar. Usar o typing club
//usar banco de dados h2