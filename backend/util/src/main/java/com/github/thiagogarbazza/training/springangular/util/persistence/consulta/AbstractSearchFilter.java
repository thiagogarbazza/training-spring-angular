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
import java.util.Collections;

import static com.github.thiagogarbazza.training.springangular.util.lang.IntegerUtils.defaultInteger;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Setter
@ToString
@SuperBuilder
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
    final Collection<OrderSpecifier> sortableColumn = this.possuiOrdenacaoPorCampo() ? this.orderableColumn() : Collections.emptyList();
    return OrderingUtils.union(sortableColumn, this.defaultOrdering());
  }

  final int numeroPagina() {
    return defaultInteger(this.numeroPagina, PAGINA_INICIAL);
  }

  final boolean possuiOrdenacaoPorCampo() {
    return ObjectUtils.allNotNull(this.ordenacaoCampo, this.ordenacaoDirecao);
  }

  final int quantidadePorPagina() {
    return defaultInteger(this.quantidadePorPagina, getQuantidadePorPaginaPadrao());
  }

  private Collection<OrderSpecifier> orderableColumn() {
    return this.ordenacaoCampo.getOrderSpecifier(ordenacaoDirecao);
  }

  final Pageable getPageable() {
    return new QPageRequest(numeroPagina(), quantidadePorPagina());
  }

  protected int getQuantidadePorPaginaPadrao() {
    return QUANTIDADE_POR_PAGINA_PADRAO;
  }
}
