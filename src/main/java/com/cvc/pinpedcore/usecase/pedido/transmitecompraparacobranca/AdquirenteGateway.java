package com.cvc.pinpedcore.usecase.pedido.transmitecompraparacobranca;

import com.cvc.pinpedcore.models.Pedido;

public interface AdquirenteGateway {

    boolean cobra(Pedido pedido);

}
