package br.com.pagbank.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PedidoModel {

  private Long id;
  private String estado;
  private MeioDePagamentoEnum meioDePagamento;
  private String numeroCartaoCredito;
  private int quantidadeParcela;
  private double frete;
  private List<ProdutoModel> produtos;
}