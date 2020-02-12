package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import static com.github.thiagogarbazza.training.springangular.util.lang.IntegerUtils.defaultInteger;

@UtilityClass
class PageableUtils {

  private static final int PAGINA_INICIAL = 0;

  static Pageable pageableBuild(final AbstractSearchFilter filtro) {

    return QPageRequest.of(
      defaultInteger(filtro.getNumeroPagina(), PAGINA_INICIAL),
      defaultInteger(filtro.getQuantidadePorPagina(), filtro.getQuantidadePorPaginaPadrao()),
      filtro.ordering()
                          );
  }
}
