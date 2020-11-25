package com.cvc.pinpedcore.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pedido {

    private int id;
    private String situacao;
    private Fatura fatura;
    private List<Produto> produtos;

}
