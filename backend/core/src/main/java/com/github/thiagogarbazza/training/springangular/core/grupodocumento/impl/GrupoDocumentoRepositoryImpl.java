package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQueryDslRepositorySupport;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.GrupoDocumentoSearchFilterHelper.grupoDocumentoSearchFilterPredicateBuilder;

@Repository
class GrupoDocumentoRepositoryImpl extends CustomQueryDslRepositorySupport<GrupoDocumento> implements GrupoDocumentoRepositoryCustom {

  protected GrupoDocumentoRepositoryImpl() {
    super(GrupoDocumento.class);
  }

  @Override
  public Collection<GrupoDocumento> search(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return from(grupoDocumento)
      .where(grupoDocumentoSearchFilterPredicateBuilder(grupoDocumentoSearchFilter))
      .orderBy(grupoDocumentoSearchFilter.ordering())
      .fetch();
  }

  @Override
  public Collection<GrupoDocumentoVO4Select> search4Select(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    QGrupoDocumentoVO4Select projection = new QGrupoDocumentoVO4Select(grupoDocumento.id, grupoDocumento.codigo, grupoDocumento.nome);

    return from(grupoDocumento)
      .select(projection)
      .where(grupoDocumentoSearchFilterPredicateBuilder(grupoDocumentoSearchFilter))
      .orderBy(grupoDocumentoSearchFilter.ordering())
      .fetch();
  }

  @Override
  public CustomPage<GrupoDocumentoVO4SearchResult> searchPaginating(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    final JPQLQuery query = from(grupoDocumento)
      .where(grupoDocumentoSearchFilterPredicateBuilder(grupoDocumentoSearchFilter));

    QGrupoDocumentoVO4SearchResult projection = new QGrupoDocumentoVO4SearchResult(grupoDocumento.id, grupoDocumento.codigo, grupoDocumento.nome,
      grupoDocumento.situacao);
    return readPage(query, grupoDocumentoSearchFilter, projection);
  }
}
