package com.cvc.pinpedcore.usecase.pedido.criapedido;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.models.Produto;
import com.cvc.pinpedcore.usecase.pedido.criapedido.impl.CriaPedidoUsecaseImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CriaPedidoUsecaseTest {

    private CriaPedidoUsecase criaPedidoUsecase;
    @Mock
    private PedidoGateway pedidoGateway;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.criaPedidoUsecase = new CriaPedidoUsecaseImpl(pedidoGateway);

        Mockito.when(pedidoGateway.cria(Mockito.any(Pedido.class))).thenAnswer((Answer<Pedido>) invocationOnMock -> {
            Pedido pedido = invocationOnMock.getArgument(0);
            pedido.setId(12);
            return pedido;
        });
    }

    @Test
    public void deveCriaPedido() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("PA").build());
        Assert.assertNotNull(pedido);
        Assert.assertNotNull(pedido.getId());
        Assert.assertEquals(12, pedido.getId(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarDF() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("DF").build());
        Assert.assertEquals(40.0, pedido.getValorFrete().doubleValue(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarGO() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("GO").build());
        Assert.assertEquals(40.0, pedido.getValorFrete().doubleValue(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarPA() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("PA").build());
        Assert.assertEquals(55.0, pedido.getValorFrete().doubleValue(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarSP() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("SP").build());
        Assert.assertEquals(0.0, pedido.getValorFrete().doubleValue(), 0.1);
    }

    @Test
    public void deveRetornaValorFretePadrao() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("SC").build());
        Assert.assertEquals(20.0, pedido.getValorFrete().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorTotalDaCompra() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("RJ").produtos(criaProdutos()).build());
        Assert.assertEquals(328.44, pedido.valorTotal().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorTotalDaCompraComICMS(){
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("PA").produtos(criaProdutos()).build());
        Assert.assertEquals(335.3798, pedido.valorTotalComICMS().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorDeTributosAoValorTotalDaCompraRJ(){
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("RJ").produtos(criaProdutos()).build());
        Assert.assertEquals(345.0723, pedido.valorTotalComICMSETributos().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorDeTributosAoValorTotalDaCompraDF(){
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("DF").produtos(criaProdutos()).build());
        Assert.assertEquals(345.0723, pedido.valorTotalComICMSETributos().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorDeTributosAoValorTotalDaCompraMG(){
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("MG").produtos(criaProdutos()).build());
        Assert.assertEquals(345.0723, pedido.valorTotalComICMSETributos().doubleValue(), 0.1);
    }

    @Test
    public void deveCalculaValorDeTributosPadraoAoValorTotalDaCompra(){
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("PA").produtos(criaProdutos()).build());
        Assert.assertEquals(347.9566, pedido.valorTotalComICMSETributos().doubleValue(), 0.1);
    }

    private List<Produto> criaProdutos() {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(Produto.builder().descricao("Produto 1").icms(new BigDecimal(1.23)).valor(new BigDecimal(100.00)).build()); /*= 101.2300*/
        produtos.add(Produto.builder().descricao("Produto 2").icms(new BigDecimal(3.34)).valor(new BigDecimal(150.09)).build()); /*= 152.3154*/
        produtos.add(Produto.builder().descricao("Produto 3").icms(new BigDecimal(2.73)).valor(new BigDecimal(78.35)).build());  /*= 81.8344*/

        return produtos;
    }
}
