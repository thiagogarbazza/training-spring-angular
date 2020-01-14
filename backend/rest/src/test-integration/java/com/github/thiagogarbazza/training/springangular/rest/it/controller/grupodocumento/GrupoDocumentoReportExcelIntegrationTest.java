package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.report.grupodocumento.GrupoDocumentoReportService;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.arquivo.Mimetypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUploadD4T.arquivoUploadExcel;
import static com.github.thiagogarbazza.training.springangular.util.validation.ViolationExceptionD4T.violationExceptionQualquer;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoReportExcelIntegrationTest {

  @Captor
  private ArgumentCaptor<GrupoDocumentoSearchFilter> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoReportService grupoDocumentoReportService;
  private MockMvc mockMvc;

  @BeforeEach
  final void beforeEach() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifySearchError() throws Exception {
    when(grupoDocumentoReportService.excel(captor.capture())).thenThrow(violationExceptionQualquer());

    this.mockMvc
      .perform(get("/grupo-documento/report-excel"))
      .andDo(result -> {
        final GrupoDocumentoSearchFilter value = captor.getValue();
        assertNull(value.getSituacoes());
        assertNull(value.getCodigo());
        assertNull(value.getNumeroPagina());
        assertNull(value.getQuantidadePorPagina());
        assertNull(value.getOrdenacaoCampo());
        assertNull(value.getOrdenacaoDirecao());
      })
      .andExpect(status().isPreconditionFailed())
      .andExpect(jsonPath("$.message", equalTo("There was some violation.")))
      .andExpect(jsonPath("$.violations", hasSize(1)))
      .andExpect(jsonPath("$.violations[0].type", equalTo("ERROR")))
      .andExpect(jsonPath("$.violations[0].key", equalTo("error-key")))
      .andExpect(jsonPath("$.violations[0].content", equalTo("error-content")));
  }

  @Test
  void verifySearchSuccess() throws Exception {
    when(grupoDocumentoReportService.excel(captor.capture())).thenReturn(arquivoUploadExcel());

    this.mockMvc
      .perform(get("/grupo-documento/report-excel"))
      .andDo(result -> {
        final GrupoDocumentoSearchFilter value = captor.getValue();
        assertNull(value.getSituacoes());
        assertNull(value.getCodigo());
        assertNull(value.getNumeroPagina());
        assertNull(value.getQuantidadePorPagina());
        assertNull(value.getOrdenacaoCampo());
        assertNull(value.getOrdenacaoDirecao());
      })
      .andExpect(status().isOk())
      .andExpect(header().string(HttpHeaders.CONTENT_TYPE, Mimetypes.MIMETYPE_PLANILHA))
      .andExpect(header().exists(HttpHeaders.CONTENT_LENGTH))
      .andExpect(header().string(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"nome-qualquer-para-o-arquivo.xlsx\""));
  }
}
