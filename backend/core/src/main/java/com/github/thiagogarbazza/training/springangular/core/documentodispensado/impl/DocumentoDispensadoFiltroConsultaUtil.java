package com.github.thiagogarbazza.training.springangular.core.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;
import static com.github.thiagogarbazza.training.springangular.util.calendario.JPQLPeriodoUtil.dataEstaContidaNoPeriodo;

@UtilityClass
class DocumentoDispensadoFiltroConsultaUtil {

  static Predicate predicateBuilder(JPQLQuery query, DocumentoDispensadoFiltroConsulta filtroConsulta) {
    BooleanBuilder conditions = new BooleanBuilder();

    if (CollectionUtils.isNotEmpty(filtroConsulta.getClientes())) {
      conditions.and(documentoDispensado.cliente.id.in(filtroConsulta.getClientes()));
    }

    if (CollectionUtils.isNotEmpty(filtroConsulta.getDocumentos())) {
      conditions.and(documentoDispensado.documento.id.in(filtroConsulta.getDocumentos()));
    }

    if (CollectionUtils.isNotEmpty(filtroConsulta.getGrupoDocumentos())) {
      conditions.and(documentoDispensado.documento.grupoDocumento.id.in(filtroConsulta.getGrupoDocumentos()));
    }

    if (CollectionUtils.isNotEmpty(filtroConsulta.getSituacoes())) {
      conditions.and(documentoDispensado.situacao.in(filtroConsulta.getSituacoes()));
    }

    conditions.and(dataEstaContidaNoPeriodo(documentoDispensado.vigencia, filtroConsulta.getDataBaseInicio(), filtroConsulta.getDataBaseFim()));

    return conditions;
  }
}
