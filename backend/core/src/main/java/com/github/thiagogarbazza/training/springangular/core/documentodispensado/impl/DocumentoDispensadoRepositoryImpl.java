package com.github.thiagogarbazza.training.springangular.core.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQuerydslRepositorySupport;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.QDocumentoDispensado.documentoDispensado;

@Repository
class DocumentoDispensadoRepositoryImpl extends CustomQuerydslRepositorySupport<DocumentoDispensado> implements DocumentoDispensadoRepositoryCustom {

  protected DocumentoDispensadoRepositoryImpl() {
    super(DocumentoDispensado.class);
  }

  @Override
  public Collection<DocumentoDispensado> pesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    final JPQLQuery<DocumentoDispensado> query = from(documentoDispensado)
      .orderBy(documentoDispensado.documento.grupoDocumento.codigo.asc(),
        documentoDispensado.documento.codigo.asc(),
        documentoDispensado.cliente.codigo.asc(),
        documentoDispensado.vigencia.inicio.desc());
    return query
      .where(DocumentoDispensadoFiltroConsultaUtil.predicateBuilder(query, filtroConsulta))
      .fetch();
  }

  @Override
  public CustomPage<DocumentoDispensado> pesquisarPaginando(final DocumentoDispensadoFiltroConsulta documentoDispensadoFiltroConsulta) {
    final JPQLQuery<DocumentoDispensado> query = from(documentoDispensado);

    query.where(DocumentoDispensadoFiltroConsultaUtil.predicateBuilder(query, documentoDispensadoFiltroConsulta));

    return super.readPage(query, documentoDispensadoFiltroConsulta, documentoDispensado);
  }
}
