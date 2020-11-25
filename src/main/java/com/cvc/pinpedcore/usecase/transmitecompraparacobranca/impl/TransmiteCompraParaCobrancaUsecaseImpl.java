package com.cvc.pinpedcore.usecase.transmitecompraparacobranca.impl;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.usecase.transmitecompraparacobranca.TransmiteCompraParaCobrancaUsecase;
import com.cvc.pinpedcore.usecase.transmitecompraparacobranca.AdquirenteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransmiteCompraParaCobrancaUsecaseImpl implements TransmiteCompraParaCobrancaUsecase {

    private final AdquirenteGateway adquirenteGateway;

    @Override
    public boolean transmitir(Pedido pedido) {
        return adquirenteGateway.cobra(pedido);
    }
}
