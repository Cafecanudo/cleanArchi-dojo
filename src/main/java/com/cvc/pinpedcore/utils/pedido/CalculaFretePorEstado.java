package com.cvc.pinpedcore.utils.pedido;

import com.cvc.pinpedcore.config.FretePorUFEnum;

import java.math.BigDecimal;

public class CalculaFretePorEstado {

    public BigDecimal calcula(String uf) {
        return BigDecimal.valueOf(FretePorUFEnum.DF.getValorFreteBy(uf));
    }
}
