package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

interface GrupoDocumentoRepositoryCustom {

  Collection<GrupoDocumento> search(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);

  Collection<GrupoDocumentoVO4Select> search4Select(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);

  CustomPage<GrupoDocumentoVO4SearchResult> searchPaginating(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);
}
