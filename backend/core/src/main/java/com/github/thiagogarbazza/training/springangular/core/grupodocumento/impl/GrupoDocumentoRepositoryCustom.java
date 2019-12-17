package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

interface GrupoDocumentoRepositoryCustom {

  Collection<GrupoDocumento> search(GrupoDocumentoSearchFilter grupoDocumentoConsultaFiltro);

  CustomPage<GrupoDocumento> searchPaginating(GrupoDocumentoSearchFilter grupoDocumentoConsultaFiltro);
}
