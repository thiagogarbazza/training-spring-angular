package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoFiltroConsulta;

import java.util.Collection;

interface GrupoDocumentoRepositoryCustom {

  Collection<GrupoDocumento> pesquisar(GrupoDocumentoFiltroConsulta filtroConsulta);
}
