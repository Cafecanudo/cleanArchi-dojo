package com.cvc.pinpedcore.config;

import java.util.Arrays;

public enum FretePorUFEnum {
    DF(40.0), GO(40.0), PA(55.0), SP(0.0);

    private double valor;

    FretePorUFEnum(double valor) {
        this.valor = valor;
    }

    public double getValorFreteBy(String uf) {
        return Arrays.stream(FretePorUFEnum.values())
                .filter(fretePorUF -> fretePorUF.toString().equalsIgnoreCase(uf))
                .findFirst()
                .map(fretePorUF -> fretePorUF.valor).orElse(20.0);
    }
}
