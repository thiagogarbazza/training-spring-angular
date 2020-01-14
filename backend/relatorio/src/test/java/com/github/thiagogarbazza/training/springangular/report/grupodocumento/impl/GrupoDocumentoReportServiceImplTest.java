package com.github.thiagogarbazza.training.springangular.report.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoD4T.grupoDocumentoAtivoQualquer;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoD4T.grupoDocumentoInativoQualquer;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GrupoDocumentoReportServiceImplTest {

  @InjectMocks
  private GrupoDocumentoReportServiceImpl grupoDocumentoReportService;
  @Mock
  private GrupoDocumentoSearchService grupoDocumentoSearchService;

  @BeforeEach
  void beforeEach() {
    initMocks(this);
  }

  @Test
  void verifyCreateExcelFile() throws IOException {
    final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter = GrupoDocumentoSearchFilter.builder().build();
    Collection<GrupoDocumento> documentoDispensados = asList(grupoDocumentoAtivoQualquer(), grupoDocumentoInativoQualquer());

    when(grupoDocumentoSearchService.search(grupoDocumentoSearchFilter)).thenReturn(documentoDispensados);

    final ArquivoUpload arquivoUpload = grupoDocumentoReportService.excel(grupoDocumentoSearchFilter);

    assertEquals("grupo-documento", arquivoUpload.getNome());
  }
}
