package com.cvc.pinpedcore.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Produto {

    private int id;
    private String descricao;
    private BigDecimal valor;
    private BigDecimal icms;
    private Pedido pedido;

}
