package com.cvc.pinpedcore.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pedido {

    private Integer id;
    private String situacao;
    private String uf;
    private double valorFrete;
    private Fatura fatura;
    private List<Produto> produtos;
}
