package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PROTECTED)
public abstract class AbstractSearchFilter<T extends OrderableColumn> {

  private static final int QUANTIDADE_POR_PAGINA_PADRAO = 10;

  private Integer numeroPagina;
  private T ordenacaoCampo;
  private OrderableDirection ordenacaoDirecao;
  private Integer quantidadePorPagina;

  protected abstract Collection<OrderSpecifier> defaultOrdering();

  public final OrderSpecifier[] ordering() {
    return OrderingUtils.union(this.ordenacaoCampo, this.ordenacaoDirecao, this.defaultOrdering());
  }

  protected int getQuantidadePorPaginaPadrao() {
    return QUANTIDADE_POR_PAGINA_PADRAO;
  }
}
