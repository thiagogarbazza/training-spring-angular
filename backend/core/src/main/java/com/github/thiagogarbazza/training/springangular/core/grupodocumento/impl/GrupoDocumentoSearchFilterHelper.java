package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;
import static com.github.thiagogarbazza.training.springangular.util.persistence.consulta.PredicateUtil.equalsIfNotNull;
import static com.github.thiagogarbazza.training.springangular.util.persistence.consulta.PredicateUtil.inIfNotNull;

@UtilityClass
class GrupoDocumentoSearchFilterHelper {

  static Predicate grupoDocumentoSearchFilterPredicateBuilder(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return new BooleanBuilder()
      .and(equalsIfNotNull(grupoDocumento.codigo, grupoDocumentoSearchFilter.getCodigo()))
      .and(inIfNotNull(grupoDocumento.situacao, grupoDocumentoSearchFilter.getSituacoes()));
  }
}
