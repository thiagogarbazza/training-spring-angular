package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
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
  public Collection<GrupoDocumento> search(final GrupoDocumentoSearchFilter grupoDocumentoConsultaFiltro) {
    return from(grupoDocumento)
      .where(grupoDocumentoSearchFilterPredicateBuilder(grupoDocumentoConsultaFiltro))
      .orderBy(grupoDocumentoConsultaFiltro.ordering())
      .fetch();
  }

  @Override
  public CustomPage<GrupoDocumento> searchPaginating(final GrupoDocumentoSearchFilter grupoDocumentoConsultaFiltro) {
    final JPQLQuery query = from(grupoDocumento)
      .where(grupoDocumentoSearchFilterPredicateBuilder(grupoDocumentoConsultaFiltro));

    return readPage(query, grupoDocumento, grupoDocumentoConsultaFiltro);
  }
}
