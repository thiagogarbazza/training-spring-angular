package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQueryDslRepositorySupport;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;

public class DocumentoRepositoryImpl extends CustomQueryDslRepositorySupport<Documento> implements DocumentoRepositoryCustom {

  protected DocumentoRepositoryImpl() {
    super(Documento.class);
  }

  @Override
  public Collection<Documento> pesquisar(final DocumentoFiltroConsulta filtroConsulta) {
    return from(documento)
      .orderBy(documento.codigo.asc())
      .fetch();
  }
}
