package com.cvc.pinpedcore.usecase.criapedido;

import com.cvc.pinpedcore.models.Pedido;
import com.cvc.pinpedcore.usecase.criapedido.impl.CriaPedidoUsecaseImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

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
        Assert.assertEquals(40.0, pedido.getValorFrete(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarGO() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("GO").build());
        Assert.assertEquals(40.0, pedido.getValorFrete(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarPA() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("PA").build());
        Assert.assertEquals(55.0, pedido.getValorFrete(), 0.1);
    }

    @Test
    public void deveRetornaValorFreteQuandoEnviarSP() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("SP").build());
        Assert.assertEquals(0.0, pedido.getValorFrete(), 0.1);
    }

    @Test
    public void deveRetornaValorFretePadrao() {
        Pedido pedido = this.criaPedidoUsecase.cria(Pedido.builder().uf("SC").build());
        Assert.assertEquals(20.0, pedido.getValorFrete(), 0.1);
    }

}
