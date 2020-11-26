package com.cvc.pinpedcore.usecase.pedido.criapedido.impl;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.utils.pedido.CalculaFretePorEstado;
import com.cvc.pinpedcore.usecase.pedido.criapedido.CriaPedidoUsecase;
import com.cvc.pinpedcore.usecase.pedido.criapedido.PedidoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriaPedidoUsecaseImpl implements CriaPedidoUsecase {

    private final PedidoGateway pedidoGateway;

    @Override
    public Pedido cria(Pedido pedido) {
        pedido.setValorFrete(new CalculaFretePorEstado().calcula(pedido.getUf()));
        return pedidoGateway.cria(pedido);
    }
}
