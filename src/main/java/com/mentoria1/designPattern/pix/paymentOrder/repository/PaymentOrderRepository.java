package com.mentoria1.designPattern.pix.paymentOrder.repository;

import com.mentoria1.designPattern.pix.paymentOrder.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, UUID> {
}
