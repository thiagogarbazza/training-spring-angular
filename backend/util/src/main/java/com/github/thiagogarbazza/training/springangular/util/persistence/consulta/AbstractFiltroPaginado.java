package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collection;

@Getter
@Setter
public abstract class AbstractFiltroPaginado<T extends OrderByColumn> {

  private static final int PAGINA_INICIAL = 0;
  private static final int QUANTIDADE_POR_PAGINA_PADRAO = 10;

  private Integer numeroPagina;
  private T ordenacaoCampo;
  private OrderByDirection ordenacaoDirecao;
  private Integer quantidadePorPagina;

  protected abstract Collection<OrderSpecifier> orderByDefault();

  public void ignorarPaginacao() {
    this.numeroPagina = null;
    this.quantidadePorPagina = Integer.MAX_VALUE;
  }

  final OrderSpecifier buildOrderByColumn() {
    return this.ordenacaoCampo.getOrderSpecifier(ordenacaoDirecao);
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

  final Pageable getPageable() {
    return new QPageRequest(numeroPagina(), quantidadePorPagina());
  }

  protected int getQuantidadePorPaginaPadrao() {
    return QUANTIDADE_POR_PAGINA_PADRAO;
  }
}
