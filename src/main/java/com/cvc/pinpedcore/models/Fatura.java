package com.cvc.pinpedcore.models;

import lombok.Data;

@Data
public class Fatura {

    private int id;
    private String modalidade;
    private double valor;
    private int parcelas;
    private Pedido pedido;
}
