package br.com.pagbank.infraesctructure.entrypoint;

import br.com.pagbank.domain.gateway.CriaPedidoGateway;
import br.com.pagbank.domain.model.MeioDePagamentoEnum;
import br.com.pagbank.domain.model.PedidoModel;
import br.com.pagbank.domain.model.ProdutoModel;
import br.com.pagbank.domain.usecase.CriaPedidoUseCaseImpl;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class CriaPedidoController {

  private final CriaPedidoGateway gateway;

  public void cria() {
    PedidoModel pedido =
        new CriaPedidoUseCaseImpl(gateway)
            .cria(
                PedidoModel.builder()
                    .estado("RN")
                    .meioDePagamento(MeioDePagamentoEnum.CREDITO)
                    .numeroCartaoCredito("5538 8032 6713 8110")
                    .quantidadeParcela(12)
                    .produtos(
                        Arrays.asList(
                            ProdutoModel.builder().descricao("Produto 1").quantidade(10).build(),
                            ProdutoModel.builder().descricao("Produto 2").quantidade(20).build()))
                    .build());

    System.out.println(pedido);
  }
}
