package com.cvc.pinpedcore.usecase.impl;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.usecase.TransmiteCompraParaCobrancaUsecase;
import com.cvc.pinpedcore.usecase.gateway.AdquirenteGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TransmiteCompraParaCobrancaUsecaseImpl implements TransmiteCompraParaCobrancaUsecase {

    private AdquirenteGateway adquirenteGateway;

    @Override
    public boolean transmitir(Pedido pedido) {
        return adquirenteGateway.cobra(pedido);
    }
}
