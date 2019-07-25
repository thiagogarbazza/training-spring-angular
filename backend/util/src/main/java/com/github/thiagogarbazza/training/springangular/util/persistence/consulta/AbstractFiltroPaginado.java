package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collection;

@Getter
@Setter
public abstract class AbstractFiltroPaginado<T extends OrderByColumn> {

  private static final int PAGINA_INICIAL = 0;
  private static final int QUANTIDADE_POR_PAGINA_PADRAO = 10;

  private Integer numeroPagina;
  private Collection<OrderBy<T>> orderBys;
  private Integer quantidadePorPagina;

  public void ignorarPaginacao() {
    this.numeroPagina = null;
    this.quantidadePorPagina = Integer.MAX_VALUE;
  }

  final int numeroPagina() {
    return this.numeroPagina == null || this.numeroPagina < 0
      ? PAGINA_INICIAL
      : this.numeroPagina;
  }

  final OrderSpecifier buildOrderByColumn() {
    return null;
  }

  final boolean possuiOrdenacaoPorCampo() {
    return false;
  }

  final int quantidadePorPagina() {
    return this.quantidadePorPagina == null || this.quantidadePorPagina < 0
      ? getQuantidadePorPaginaPadrao()
      : this.quantidadePorPagina;
  }

  public final Pageable getPageable() {
    return new QPageRequest(numeroPagina(), quantidadePorPagina());
  }

  protected int getQuantidadePorPaginaPadrao() {
    return QUANTIDADE_POR_PAGINA_PADRAO;
  }
}
