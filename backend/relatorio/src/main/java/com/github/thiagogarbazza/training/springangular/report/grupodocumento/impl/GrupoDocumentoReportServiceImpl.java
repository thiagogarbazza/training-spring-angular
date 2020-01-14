package com.github.thiagogarbazza.training.springangular.report.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.report.grupodocumento.GrupoDocumentoReportService;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class GrupoDocumentoReportServiceImpl implements GrupoDocumentoReportService {

  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;

  @Override
  public ArquivoUpload excel(final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter) {
    final Collection<GrupoDocumento> grupoDocumentos = grupoDocumentoSearchService.search(grupoDocumentoSearchFilter);

    return new GrupoDocumentoReportExcel(grupoDocumentos).build();
  }
}
