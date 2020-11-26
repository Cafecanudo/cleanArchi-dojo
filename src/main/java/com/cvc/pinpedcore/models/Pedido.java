package com.cvc.pinpedcore.models;

import com.cvc.pinpedcore.utils.pedido.CalculaValorTotalDaCompraComICMS;
import com.cvc.pinpedcore.utils.pedido.CalculaTributo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Pedido {

    private Integer id;
    private String situacao;
    private String uf;
    private BigDecimal valorFrete;
    private Fatura fatura;
    private List<Produto> produtos;

    public BigDecimal valorTotal() {
        return new BigDecimal(produtos.stream().mapToDouble(produto -> produto.getValor().doubleValue()).sum());
    }

    public BigDecimal valorTotalComICMS() {
        return CalculaValorTotalDaCompraComICMS.calcula(produtos);
    }

    public BigDecimal valorTotalComICMSETributos() {
        return CalculaTributo.calcula(this.uf, CalculaValorTotalDaCompraComICMS.calcula(produtos));
    }
}
