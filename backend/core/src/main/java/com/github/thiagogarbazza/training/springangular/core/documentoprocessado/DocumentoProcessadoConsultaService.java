package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

public interface DocumentoProcessadoConsultaService {

  Collection<DocumentoProcessado> pesquisar(DocumentoProcessadoFiltroConsulta filtroConsulta);
  CustomPage<DocumentoProcessado> pesquisarPaginando(DocumentoProcessadoFiltroConsulta filtroConsulta);
}
