package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;

@Repository
class GrupoDocumentoRepositoryImpl extends CustomQueryDslRepositorySupport<GrupoDocumento> implements GrupoDocumentoRepositoryCustom {

  protected GrupoDocumentoRepositoryImpl() {
    super(GrupoDocumento.class);
  }

  @Override
  public Collection<GrupoDocumento> pesquisar(final GrupoDocumentoFiltroConsulta filtroConsulta) {
    return from(grupoDocumento)
      .orderBy(grupoDocumento.codigo.asc())
      .fetch();
  }
}
