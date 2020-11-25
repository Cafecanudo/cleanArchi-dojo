package com.cvc.pinpedcore.usecase.criapedido;

import com.cvc.pinpedcore.config.FretePorUFEnum;

public class CalculaFretePorEstado {

    public static double calcula(String uf) {
        return FretePorUFEnum.DF.getValorFreteBy(uf);
    }
}
