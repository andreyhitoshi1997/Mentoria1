package com.mentoria1.designPattern.pix.paymentOrder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "payment_order")
public class PaymentOrder {

    @Id
    public UUID id;

    @Column(name = "amount")
    public BigDecimal amount;

    @Column(name = "created_at")
    //Instando como um ponto de tempo
    public Instant createdAt;

    @Column(name = "updated_at")
    public Instant updatedAt;

    @Column(name = "external_id")
    // Armazenar como string como boa prática de desenvolvimento para id's externos
    // Quando eu estou lidando com apps terceiros, para garantir que o id que eu criei, é o que estou mexendo
    //Ter certeza de que está batendo na entidade correta
    public String externalId;

    @Column(name = "initiation_method")
    // Utilizo para mostrar qual o método utilizado nesse caso
    public PaymentInitiationMethod initiationMethod;
}
