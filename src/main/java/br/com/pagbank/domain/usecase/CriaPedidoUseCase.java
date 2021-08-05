package br.com.pagbank.domain.usecase;

import br.com.pagbank.domain.model.PedidoModel;

@FunctionalInterface
public interface CriaPedidoUseCase {

  PedidoModel cria(PedidoModel pedido);
}
