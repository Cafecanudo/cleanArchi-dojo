package com.cvc.pinpedcore.models;

import lombok.Data;

@Data
public class Produto {

    private int id;
    private String descricao;
    private double valor;
    private double icms;
    private Pedido pedido;

}
