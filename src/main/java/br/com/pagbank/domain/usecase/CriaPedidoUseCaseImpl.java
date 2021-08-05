package br.com.pagbank.domain.usecase;

import br.com.pagbank.domain.gateway.CriaPedidoGateway;
import br.com.pagbank.domain.model.PedidoModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriaPedidoUseCaseImpl implements CriaPedidoUseCase {

  private final CriaPedidoGateway gateway;

  @Override
  public PedidoModel cria(PedidoModel pedido) {
    setaValorPadraoDeFrete(pedido);

    quandoForInformadoOsEstadosDfEGoDeveSeCobrarFrete(pedido);
    quandoForInformadoOsEstadosPADeveSeCobrarFrete(pedido);

    quandoForInformadoOsEstadosSPNaoDeveSeCobrarFrete(pedido);
    quandoForInformadoOsEstadosRNDeveSeCobrarFrete(pedido);

    return this.gateway.salva(pedido);
  }

  private void quandoForInformadoOsEstadosRNDeveSeCobrarFrete(PedidoModel pedido) {
    if (pedido.getEstado().equals("RN")) {
      pedido.setFrete(70d);
    }
  }

  private void quandoForInformadoOsEstadosSPNaoDeveSeCobrarFrete(PedidoModel pedido) {
    if (pedido.getEstado().equals("SP")) {
      pedido.setFrete(0d);
    }
  }

  private void setaValorPadraoDeFrete(PedidoModel pedido) {
    pedido.setFrete(20d);
  }

  private void quandoForInformadoOsEstadosPADeveSeCobrarFrete(PedidoModel pedido) {
    if (pedido.getEstado().equals("PA")) {
      pedido.setFrete(55d);
    }
  }

  private void quandoForInformadoOsEstadosDfEGoDeveSeCobrarFrete(PedidoModel pedido) {
    if (pedido.getEstado().equals("DF") || pedido.getEstado().equals("GO")) {
      pedido.setFrete(this.gateway.getQuandoForInformadoOsEstadosDfEGoDeveSeCobrar40deFrete());
    }
  }
}