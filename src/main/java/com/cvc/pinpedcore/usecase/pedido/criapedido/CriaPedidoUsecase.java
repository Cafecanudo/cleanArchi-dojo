package com.cvc.pinpedcore.usecase.pedido.criapedido;

import com.cvc.pinpedcore.models.Pedido;

@FunctionalInterface
public interface CriaPedidoUsecase {

    Pedido cria(Pedido build);
}
