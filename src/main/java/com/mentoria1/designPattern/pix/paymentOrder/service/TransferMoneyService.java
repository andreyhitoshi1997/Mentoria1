package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;

import java.util.UUID;

public class TransferMoneyService {
    final private InitiatePaymentCommand initiateCommand;

    public TransferMoneyService(InitiatePaymentCommand initiateCommand) {
        this.initiateCommand = initiateCommand;
    }

    public PaymentOrder execute(){
        PaymentOrder paymentOrder = this.initiateCommand.execute();
        paymentOrder.setId(UUID.randomUUID());
        paymentOrder.setExternalId(UUID.randomUUID().toString());
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