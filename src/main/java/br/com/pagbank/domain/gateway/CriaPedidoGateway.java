package br.com.pagbank.domain.gateway;

import br.com.pagbank.domain.model.PedidoModel;

public interface CriaPedidoGateway {

  PedidoModel salva(PedidoModel pedido);
  
  double getQuandoForInformadoOsEstadosDfEGoDeveSeCobrar40deFrete();
}
