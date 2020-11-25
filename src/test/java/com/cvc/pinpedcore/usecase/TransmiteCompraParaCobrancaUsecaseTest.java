package com.cvc.pinpedcore.usecase;

import com.cvc.pinpedcore.models.Pedido;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TransmiteCompraParaCobrancaUsecaseTest {

    private TransmiteCompraParaCobrancaUsecase transmiteCompraParaCobrancaUsecase;

    @Before
    public void setup() {
        this.transmiteCompraParaCobrancaUsecase = new TransmiteCompraParaCobrancaUsecase();
    }

    @Test
    public void deveTransmitirCompra() {
        boolean result = this.transmiteCompraParaCobrancaUsecase.transmitir(Pedido.builder().build());
        assertTrue(result);
    }

}
