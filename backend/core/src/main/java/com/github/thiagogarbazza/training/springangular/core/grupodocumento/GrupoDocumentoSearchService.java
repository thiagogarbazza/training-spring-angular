package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

public interface GrupoDocumentoSearchService {

  Collection<GrupoDocumento> search(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);

  CustomPage<GrupoDocumento> searchPaginating(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);
}
