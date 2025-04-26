package com.mentoria1.designPattern.pix.paymentOrder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PixKeyPaymentOrderRequest {
    private String pixKey;
    private BigDecimal amount;
}
