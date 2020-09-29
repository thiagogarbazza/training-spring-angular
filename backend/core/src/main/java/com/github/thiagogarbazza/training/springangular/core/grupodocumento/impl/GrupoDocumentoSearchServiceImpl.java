package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class GrupoDocumentoSearchServiceImpl implements GrupoDocumentoSearchService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  @Override
  public Collection<GrupoDocumento> search(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoRepository.search(grupoDocumentoSearchFilter);
  }

  @Override
  public Collection<GrupoDocumentoVO4Select> search4Select(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoRepository.search4Select(grupoDocumentoSearchFilter);
  }

  @Override
  public CustomPage<GrupoDocumentoVO4SearchResult> searchPaginating(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    return grupoDocumentoRepository.search4Pages(grupoDocumentoSearchFilter);
  }
}
