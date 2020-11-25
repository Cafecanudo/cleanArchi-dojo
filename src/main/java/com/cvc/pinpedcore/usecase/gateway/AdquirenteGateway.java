package com.cvc.pinpedcore.usecase.gateway;

import com.cvc.pinpedcore.models.Pedido;

public interface AdquirenteGateway {

    boolean cobra(Pedido pedido);

}
