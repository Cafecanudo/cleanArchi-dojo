package com.cvc.pinpedcore.usecase.criapedido;

import com.cvc.pinpedcore.models.Pedido;

@FunctionalInterface
public interface CriaPedidoUsecase {

    Pedido cria(Pedido build);
}
