package com.github.thiagogarbazza.training.springangular.report.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.cliente.ClienteD4T.clienteMickeyMouse;
import static com.github.thiagogarbazza.training.springangular.core.cliente.ClienteD4T.clienteThiagoGarbazza;
import static com.github.thiagogarbazza.training.springangular.core.documento.DocumentoD4T.documentoABC01;
import static com.github.thiagogarbazza.training.springangular.core.documento.DocumentoD4T.documentoXYZ01;
import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado.ATIVO;
import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado.INATIVO;
import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoD4T.periodoAberto;
import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoD4T.periodoFechado;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DocumentoDispensadoRelatorioServiceImplTest {

  @Mock
  private DocumentoDispensadoConsultaService documentoDispensadoConsultaService;
  @InjectMocks
  private DocumentoDispensadoRelatorioServiceImpl documentoDispensadoRelatorioService;

  @BeforeEach
  void beforeEach() {
    initMocks(this);
  }

  @Test
  void verifyCreateExcelFile() throws IOException {
    DocumentoDispensadoFiltroConsulta filtroConsulta = DocumentoDispensadoFiltroConsulta.builder().build();
    Collection<DocumentoDispensado> documentoDispensados = asList(
      DocumentoDispensado.builder().cliente(clienteMickeyMouse()).documento(documentoABC01()).vigencia(periodoAberto()).situacao(INATIVO).build(),
      DocumentoDispensado.builder().cliente(clienteThiagoGarbazza()).documento(documentoABC01()).vigencia(periodoAberto()).situacao(ATIVO).build(),
      DocumentoDispensado.builder().cliente(clienteMickeyMouse()).documento(documentoXYZ01()).vigencia(periodoFechado()).situacao(INATIVO).build(),
      DocumentoDispensado.builder().cliente(clienteThiagoGarbazza()).documento(documentoXYZ01()).vigencia(periodoFechado()).situacao(ATIVO).build()
                                                                 );

    when(documentoDispensadoConsultaService.pesquisar(filtroConsulta)).thenReturn(documentoDispensados);

    final ArquivoUpload arquivoUpload = documentoDispensadoRelatorioService.gerarRelatorioExcel(filtroConsulta);

    assertEquals("documentos-dispensados", arquivoUpload.getNome());
  }
}

