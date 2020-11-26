package com.cvc.pinpedcore.utils.pedido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculaTributo {

    public static BigDecimal calcula(String uf, BigDecimal totalComICMS) {
        if (tributarParaRJDFMG(uf)) {
            return calculaValorTributo(totalComICMS, 2.89);
        }
        return calculaValorTributo(totalComICMS, 3.75);
    }

    private static BigDecimal calculaValorTributo(BigDecimal totalComICMS, double v) {
        return totalComICMS.add(new BigDecimal(v).multiply(totalComICMS)
                .divide(new BigDecimal(100), 4, RoundingMode.UP)).setScale(4, RoundingMode.UP);
    }

    private static boolean tributarParaRJDFMG(String uf) {
        return uf.equals("RJ") || uf.equals("DF") || uf.equals("MG");
    }
}
