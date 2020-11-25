package com.cvc.pinpedcore.usecase.transmitecompraparacobranca;

import com.cvc.pinpedcore.models.Pedido;

@FunctionalInterface
public interface TransmiteCompraParaCobrancaUsecase {

    boolean transmitir(Pedido pedido);
}
