package br.com.pagbank.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoModel {

  private String descricao;
  private int quantidade;

  public boolean isValid() {
    return getDescricao() != null && !getDescricao().isEmpty() && getQuantidade() > 0;
  }
}
