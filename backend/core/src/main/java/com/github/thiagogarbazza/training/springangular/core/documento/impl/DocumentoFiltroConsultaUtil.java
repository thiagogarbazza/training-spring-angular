package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;

@UtilityClass
class DocumentoFiltroConsultaUtil {

  static Predicate predicateBuilder(JPQLQuery query, DocumentoFiltroConsulta filtroConsulta) {
    BooleanBuilder conditions = new BooleanBuilder();

    if (CollectionUtils.isNotEmpty(filtroConsulta.getSituacoes())) {
      conditions.and(documento.situacao.in(filtroConsulta.getSituacoes()));
    }

    return conditions;
  }
}
