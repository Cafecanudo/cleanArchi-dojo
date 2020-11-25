package com.cvc.pinpedcore.usecase.criapedido.impl;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.usecase.criapedido.CalculaFretePorEstado;
import com.cvc.pinpedcore.usecase.criapedido.CriaPedidoUsecase;
import com.cvc.pinpedcore.usecase.criapedido.PedidoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriaPedidoUsecaseImpl implements CriaPedidoUsecase {

    private final PedidoGateway pedidoGateway;

    @Override
    public Pedido cria(Pedido pedido) {
        pedido.setValorFrete(CalculaFretePorEstado.calcula(pedido.getUf()));
        return pedidoGateway.cria(pedido);
    }
}
