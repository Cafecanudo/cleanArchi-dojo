package br.com.pagbank.infraesctructure;

import br.com.pagbank.infraesctructure.dataprovider.CriaPedidoGatewayImpl;
import br.com.pagbank.infraesctructure.entrypoint.CriaPedidoController;

public class ApplicationStart {

  public static void main(String[] args) {
    CriaPedidoGatewayImpl gateway = new CriaPedidoGatewayImpl();
    new CriaPedidoController(gateway).cria();
  }
}
