package com.github.thiagogarbazza.training.springangular.core.documentoprocessado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessado;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentoprocessado.DocumentoProcessadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class DocumentoProcessadoConsultaServiceImpl implements DocumentoProcessadoConsultaService {

  public Collection<DocumentoProcessado> pesquisar(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    return null;
  }

  @Override
  public CustomPage<DocumentoProcessado> pesquisarPaginando(final DocumentoProcessadoFiltroConsulta filtroConsulta) {
    return null;
  }
}
