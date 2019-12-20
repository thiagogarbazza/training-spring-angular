package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

public interface GrupoDocumentoSearchService {

  Collection<GrupoDocumento> search(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);

  Collection<GrupoDocumentoVO4Select> search4Select(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);

  CustomPage<GrupoDocumentoVO4SearchResult> searchPaginating(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);
}
