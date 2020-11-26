package com.cvc.pinpedcore.usecase.pedido.transmitecompraparacobranca;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.usecase.pedido.transmitecompraparacobranca.impl.TransmiteCompraParaCobrancaUsecaseImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class TransmiteCompraParaCobrancaUsecaseTest {

    private TransmiteCompraParaCobrancaUsecase transmiteCompraParaCobrancaUsecase;
    @Mock
    private AdquirenteGateway adquirenteGateway;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.transmiteCompraParaCobrancaUsecase = new TransmiteCompraParaCobrancaUsecaseImpl(adquirenteGateway);
    }

    @Test
    public void deveTransmitirCompra() {
        when(adquirenteGateway.cobra(Mockito.any(Pedido.class))).thenReturn(true);

        boolean result = this.transmiteCompraParaCobrancaUsecase.transmitir(Pedido.builder().build());
        assertTrue(result);
    }

    @Test
    public void deve() {
        when(adquirenteGateway.cobra(Mockito.any(Pedido.class))).thenReturn(false);

        boolean result = this.transmiteCompraParaCobrancaUsecase.transmitir(Pedido.builder().build());
        assertFalse(result);
    }

}
