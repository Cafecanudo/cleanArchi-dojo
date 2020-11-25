package com.cvc.pinpedcore.usecase.transmitecompraparacobranca;

import com.cvc.pinpedcore.models.Pedido;

public interface AdquirenteGateway {

    boolean cobra(Pedido pedido);

}
