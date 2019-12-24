package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collection;

import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor(access = PROTECTED)
public abstract class AbstractSearchFilter<T extends OrderableColumn> {

  private static final int PAGINA_INICIAL = 0;
  private static final int QUANTIDADE_POR_PAGINA_PADRAO = 10;

  private Integer numeroPagina;
  private T ordenacaoCampo;
  private OrderableDirection ordenacaoDirecao;
  private Integer quantidadePorPagina;

  protected abstract Collection<OrderSpecifier> defaultOrdering();

  public final OrderSpecifier[] ordering() {
    return OrderingHelper.union(this.possuiOrdenacaoPorCampo() ? this.orderableColumn() : null, this.defaultOrdering());
  }

  final int numeroPagina() {
    return this.numeroPagina == null || this.numeroPagina < 0
      ? PAGINA_INICIAL
      : this.numeroPagina;
  }

  final boolean possuiOrdenacaoPorCampo() {
    return ObjectUtils.allNotNull(this.ordenacaoCampo, this.ordenacaoDirecao);
  }

  final int quantidadePorPagina() {
    return this.quantidadePorPagina == null || this.quantidadePorPagina < 0
      ? getQuantidadePorPaginaPadrao()
      : this.quantidadePorPagina;
  }

  private OrderSpecifier orderableColumn() {
    return this.ordenacaoCampo.getOrderSpecifier(ordenacaoDirecao);
  }

  final Pageable getPageable() {
    return new QPageRequest(numeroPagina(), quantidadePorPagina());
  }

  protected int getQuantidadePorPaginaPadrao() {
    return QUANTIDADE_POR_PAGINA_PADRAO;
  }
}
