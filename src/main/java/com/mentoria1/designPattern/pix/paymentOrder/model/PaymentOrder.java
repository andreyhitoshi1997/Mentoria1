package com.mentoria1.designPattern.pix.paymentOrder.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Table("payment_order")
public class PaymentOrder {

    @Id
    public UUID id;

    @Column("amount")
    public BigDecimal amount;

    @CreatedDate
    @Column("created_at")
    //Instando como um ponto de tempo
    public Instant createdAt;

    @LastModifiedDate
    @Column("updated_at")
    public Instant updatedAt;

    @Column("external_id")
    // Armazenar como string como boa prática de desenvolvimento para id's externos
    // Quando eu estou lidando com apps terceiros, para garantir que o id que eu criei, é o que estou mexendo
    //Ter certeza de que está batendo na entidade correta
    public String externalId;

    @Column("initiation_method")
    // Utilizo para mostrar qual o método utilizado nesse caso
    public PaymentInitiationMethod initiationMethod;
}
