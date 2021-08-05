package br.com.pagbank.domain.usecase;

import br.com.pagbank.domain.config.exception.PedidoInvalidoException;
import br.com.pagbank.domain.config.exception.ProdutosInvalidoException;
import br.com.pagbank.domain.gateway.CriaPedidoGateway;
import br.com.pagbank.domain.model.MeioDePagamentoEnum;
import br.com.pagbank.domain.model.PedidoModel;
import br.com.pagbank.domain.model.ProdutoModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.Arrays;

public class CriaPedidoUseCaseTest {

  private CriaPedidoUseCase useCase;
  @Mock private CriaPedidoGateway gateway;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    this.useCase = new CriaPedidoUseCaseImpl(gateway);

    Mockito.when(this.gateway.salva(Mockito.any()))
        .thenAnswer(
            (Answer<PedidoModel>)
                invocationOnMock -> {
                  PedidoModel model = invocationOnMock.getArgument(0);
                  model.setId(1L);
                  return model;
                });

    Mockito.when(this.gateway.getQuandoForInformadoOsEstadosDfEGoDeveSeCobrar40deFrete())
        .thenReturn(40.00d);
  }

  @Test
  public void deveRetornaPedido() {
    PedidoModel pedido = criaPedido("DF");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertNotNull(pedido_criado);
    Assert.assertNotNull(pedido_criado.getId());
    Assert.assertNotNull(pedido_criado.getProdutos());
    Assert.assertNotNull(pedido_criado.getEstado());
    Assert.assertEquals("DF", pedido_criado.getEstado());
    Assert.assertNotNull(pedido_criado.getMeioDePagamento());
    Assert.assertEquals(MeioDePagamentoEnum.CREDITO, pedido_criado.getMeioDePagamento());
    Assert.assertNotNull(pedido_criado.getNumeroCartaoCredito());
    Assert.assertEquals("5538 8032 6713 8110", pedido_criado.getNumeroCartaoCredito());
    Assert.assertNotNull(pedido_criado.getQuantidadeParcela());
    Assert.assertEquals(12, pedido_criado.getQuantidadeParcela());
  }

  @Test
  public void quandoForInformadoOsEstadosDFDeveSeCobrar40deFrete() {
    PedidoModel pedido = criaPedido("DF");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(40.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void quandoForInformadoOsEstadosGODeveSeCobrar40deFrete() {
    PedidoModel pedido = criaPedido("GO");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(40.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void quandoForInformadoOsEstadosPADeveSeCobrar55deFrete() {
    PedidoModel pedido = criaPedido("PA");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(55.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void quandoForInformadoOsEstadosSPNaoDeveSeCobrarFrete() {
    PedidoModel pedido = criaPedido("SP");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(0.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void quandoForInformadoCobrarFrete20Reais() {
    PedidoModel pedido = criaPedido("MG");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(20.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void quandoForInformadoCobrarFrete70Reais() {
    PedidoModel pedido = criaPedido("RN");

    PedidoModel pedido_criado = this.useCase.cria(pedido);
    Assert.assertEquals(70.00d, pedido_criado.getFrete(), 1);
  }

  @Test
  public void deveRetornaExcecaoQuandoModelForNull() {
    Assert.assertThrows(PedidoInvalidoException.class, () -> this.useCase.cria(null));
  }

  @Test
  public void deveRetornaExcecaoQuandoModelPedidoInvalido() {
    Assert.assertThrows(
        PedidoInvalidoException.class,
        () ->
            this.useCase.cria(
                PedidoModel.builder()
                    .meioDePagamento(MeioDePagamentoEnum.CREDITO)
                    .numeroCartaoCredito("5538 8032 6713 8110")
                    .quantidadeParcela(12)
                    .produtos(
                        Arrays.asList(
                            ProdutoModel.builder().descricao("Produto 1").quantidade(10).build(),
                            ProdutoModel.builder().descricao("Produto 2").quantidade(20).build()))
                    .build()));
  }

  @Test
  public void deveRetornaExcecaoQuandoModelPedidodalido() {
    Assert.assertThrows(
        PedidoInvalidoException.class,
        () ->
            this.useCase.cria(
                PedidoModel.builder()
                    .estado("DF")
                    .numeroCartaoCredito("5538 8032 6713 8110")
                    .quantidadeParcela(12)
                    .produtos(
                        Arrays.asList(
                            ProdutoModel.builder().descricao("Produto 1").quantidade(10).build(),
                            ProdutoModel.builder().descricao("Produto 2").quantidade(20).build()))
                    .build()));
  }

  @Test
  public void deveRetornaExcecaoQuandoProdutosInvalidos() {
    Assert.assertThrows(
        ProdutosInvalidoException.class,
        () ->
            this.useCase.cria(
                PedidoModel.builder()
                    .estado("DF")
                    .meioDePagamento(MeioDePagamentoEnum.CREDITO)
                    .numeroCartaoCredito("5538 8032 6713 8110")
                    .quantidadeParcela(12)
                    .produtos(Arrays.asList(ProdutoModel.builder().build()))
                    .build()));
  }

  private PedidoModel criaPedido(String pa) {
    return PedidoModel.builder()
        .estado(pa)
        .meioDePagamento(MeioDePagamentoEnum.CREDITO)
        .numeroCartaoCredito("5538 8032 6713 8110")
        .quantidadeParcela(12)
        .produtos(
            Arrays.asList(
                ProdutoModel.builder().descricao("Produto 1").quantidade(10).build(),
                ProdutoModel.builder().descricao("Produto 2").quantidade(20).build()))
        .build();
  }
}
