package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQuerydslRepositorySupport;
import com.querydsl.jpa.JPQLQuery;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;

public class DocumentoRepositoryImpl extends CustomQuerydslRepositorySupport<Documento> implements DocumentoRepositoryCustom {

  protected DocumentoRepositoryImpl() {
    super(Documento.class);
  }

  @Override
  public Collection<Documento> pesquisar(final DocumentoFiltroConsulta filtroConsulta) {
    final JPQLQuery<Documento> query = from(documento);
    query.where(DocumentoFiltroConsultaUtil.predicateBuilder(query, filtroConsulta));

    return query
      .orderBy(documento.grupoDocumento.codigo.asc(), documento.codigo.asc())
      .fetch();
  }
}
