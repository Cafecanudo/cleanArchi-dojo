package br.com.pagbank.infraesctructure.dataprovider;

import br.com.pagbank.domain.gateway.CriaPedidoGateway;
import br.com.pagbank.domain.model.PedidoModel;

public class CriaPedidoGatewayImpl implements CriaPedidoGateway {

  @Override
  public PedidoModel salva(PedidoModel pedido) {
    pedido.setId(1L);
    return pedido;
  }

  @Override
  public double getQuandoForInformadoOsEstadosDfEGoDeveSeCobrar40deFrete() {
    return 40d;
  }
}
