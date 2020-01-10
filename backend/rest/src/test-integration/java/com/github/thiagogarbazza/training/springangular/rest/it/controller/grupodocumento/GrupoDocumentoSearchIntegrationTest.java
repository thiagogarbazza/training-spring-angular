package com.github.thiagogarbazza.training.springangular.rest.it.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResult;
import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPageD4T;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSortableColumns.CODIGO;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4SearchResultD4T.grupoDocumentoVO4SearchResultQualquer;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.ATIVO;
import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.INATIVO;
import static com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection.ASC;
import static com.github.thiagogarbazza.training.springangular.util.validation.SimpleMessageD4T.simpleMessageWarning;
import static com.github.thiagogarbazza.training.springangular.util.validation.ViolationExceptionD4T.violationExceptionQualquer;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestIntegrationTestRunner
class GrupoDocumentoSearchIntegrationTest {

  @Captor
  private ArgumentCaptor<GrupoDocumentoSearchFilter> captor;
  @Autowired
  private WebApplicationContext context;
  @MockBean
  private GrupoDocumentoSearchService grupoDocumentoSearchService;
  private MockMvc mockMvc;

  @BeforeEach
  final void setupWebTest() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  void verifySearchError() throws Exception {
    when(grupoDocumentoSearchService.searchPaginating(captor.capture())).thenThrow(violationExceptionQualquer());

    this.mockMvc
      .perform(get("/grupo-documento/search"))
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
  @Disabled("Desabilitado até corrigir a conversão de java.time e dos Enuns")
  void verifySearchSuccess() throws Exception {

    final CustomPage<GrupoDocumentoVO4SearchResult> page = CustomPageD4T.newCustomPage(grupoDocumentoVO4SearchResultQualquer());
    page.addMessage(simpleMessageWarning());
    page.addParameter("doSomething", true);
    when(grupoDocumentoSearchService.searchPaginating(captor.capture())).thenReturn(page);

    this.mockMvc
      .perform(get("/grupo-documento/search"))
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
      .andExpect(jsonPath("$.content", hasSize(1)))
      .andExpect(jsonPath("$.content[0].id", equalTo("df160f6e-e4e5-4fbf-a39f-d92acff9eade")))
      .andExpect(jsonPath("$.content[0].codigo", equalTo("GRP-CODIGO")))
      .andExpect(jsonPath("$.content[0].nome", equalTo("GRP-NOME")))
      .andExpect(jsonPath("$.content[0].situacao", notNullValue()))
//      .andExpect(jsonPath("$.content[0].situacao.id", equalTo(1)))
//      .andExpect(jsonPath("$.content[0].situacao.description", equalTo("Ativo")))
      .andExpect(jsonPath("$.content[0].actions.doDetail.doAction", equalTo(true)))
      .andExpect(jsonPath("$.content[0].actions.doDetail.name", equalTo("Detalhar")))
      .andExpect(jsonPath("$.content[0].actions.doDetail.tooltip", equalTo("Clique aqui para detalhar este registro.")))
      .andExpect(jsonPath("$.content[0].actions.doDelete.doAction", equalTo(false)))
      .andExpect(jsonPath("$.content[0].actions.doDelete.name", equalTo("Deletar")))
      .andExpect(jsonPath("$.content[0].actions.doDelete.tooltip", equalTo("Clique aqui para deletar este registro.")))
      .andExpect(jsonPath("$.contentSize", equalTo(1)))
      .andExpect(jsonPath("$.hasContent", equalTo(true)))
      .andExpect(jsonPath("$.hasNext", equalTo(false)))
      .andExpect(jsonPath("$.hasPrevious", equalTo(false)))
      .andExpect(jsonPath("$.isEmpty", equalTo(false)))
      .andExpect(jsonPath("$.isFirst", equalTo(true)))
      .andExpect(jsonPath("$.isLast", equalTo(true)))
      .andExpect(jsonPath("$.messages", hasSize(1)))
      .andExpect(jsonPath("$.messages[0].type", equalTo("WARNING")))
      .andExpect(jsonPath("$.messages[0].key", equalTo("warning-key")))
      .andExpect(jsonPath("$.messages[0].content", equalTo("warning-contet")))
      .andExpect(jsonPath("$.parameters.doSomething", equalTo(true)))
      .andExpect(jsonPath("$.number", equalTo(0)))
      .andExpect(jsonPath("$.size", equalTo(10)))
      .andExpect(jsonPath("$.totalElements", equalTo(1)))
      .andExpect(jsonPath("$.totalPages", equalTo(1)))
    ;
  }

  @Test
  void verifySearchSuccessComFiltros() throws Exception {
    when(grupoDocumentoSearchService.searchPaginating(captor.capture())).thenReturn(CustomPageD4T.pageEmpty());

    this.mockMvc
      .perform(get("/grupo-documento/search"
        + "?codigo=GRP-CODIGO"
        + "&situacoes=ATIVO&situacoes=INATIVO"
        + "&numeroPagina=5"
        + "&quantidadePorPagina=25"
        + "&ordenacaoCampo=CODIGO"
        + "&ordenacaoDirecao=ASC"))
      .andDo(result -> {
        final GrupoDocumentoSearchFilter value = captor.getValue();
        assertEquals("GRP-CODIGO", value.getCodigo());
        assertIterableEquals(Arrays.asList(ATIVO, INATIVO), value.getSituacoes());
        assertEquals(5, value.getNumeroPagina());
        assertEquals(25, value.getQuantidadePorPagina());
        assertEquals(CODIGO, value.getOrdenacaoCampo());
        assertEquals(ASC, value.getOrdenacaoDirecao());
      })
      .andExpect(status().isOk());
  }
}
