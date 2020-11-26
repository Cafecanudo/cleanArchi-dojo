package com.cvc.pinpedcore.utils.pedido;

import com.cvc.pinpedcore.models.Produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculaValorTotalDaCompraComICMS {

    public static BigDecimal calcula(List<Produto> produtos) {
        return new BigDecimal(produtos.stream().mapToDouble(produto -> produto.getValor()
                .add(calculaPercentualDeICMSSobreOValorDoProduto(produto)).doubleValue()).sum())
                .setScale(4, RoundingMode.UP);
    }

    private static BigDecimal calculaPercentualDeICMSSobreOValorDoProduto(Produto produto) {
        return produto.getIcms().multiply(new BigDecimal(100)).divide(produto.getValor(), 12, RoundingMode.UP);
    }
}
