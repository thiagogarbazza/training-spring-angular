package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;

import java.util.Collection;

interface DocumentoRepositoryCustom {

  Collection<Documento> pesquisar(DocumentoFiltroConsulta filtroConsulta);
}
