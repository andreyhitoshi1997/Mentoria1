package com.mentoria1.designPattern.pix.paymentOrder.service;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentInitiationMethod;
import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;

import java.math.BigDecimal;

public class BankingAccountInitiatePaymentCommand  implements InitiatePaymentCommand{
    final private String cpf;
    final private String agency;
    final private String branchNumber;
    final private BigDecimal amount;

    public BankingAccountInitiatePaymentCommand(String cpf, String agency, String branchNumber, BigDecimal amount) {
        this.cpf = cpf;
        this.agency = agency;
        this.branchNumber = branchNumber;
        this.amount = amount;
    }

    public PaymentOrder execute(){
        System.out.println("Creating payment Order by bank Account " + this.cpf);
        System.out.println("Creating payment Order by bank Account " + this.agency);
        System.out.println("Creating payment Order by bank Account " + this.branchNumber);
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setAmount(this.amount);
        paymentOrder.setInitiationMethod(PaymentInitiationMethod.BANKING_ACOUNT);
        return paymentOrder;
    }
}
