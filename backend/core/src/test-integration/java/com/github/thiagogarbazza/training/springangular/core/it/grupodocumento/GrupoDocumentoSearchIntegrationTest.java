package com.github.thiagogarbazza.training.springangular.core.it.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSortableColumns;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.GrupoDocumentoService4T;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Collections;

@CoreIntegrationTestRunner
class GrupoDocumentoSearchIntegrationTest {

  @Autowired
  private GrupoDocumentoSearchService grupoDocumentoSearchService;
  @Autowired
  private GrupoDocumentoService4T grupoDocumentoService4T;

  @Test
  void verify() {
    final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter = GrupoDocumentoSearchFilter.builder()
      .codigo("GRP002")
      .situacoes(Collections.singleton(SituacaoGrupoDocumento.ATIVO))
      .numeroPagina(0)
      .quantidadePorPagina(1)
      .ordenacaoCampo(GrupoDocumentoSortableColumns.CODIGO)
      .ordenacaoDirecao(OrderableDirection.ASC)
      .build();

    final Collection<GrupoDocumento> grupoDocumentos = grupoDocumentoSearchService.search(grupoDocumentoSearchFilter);
    Assertions.assertNotNull(grupoDocumentos);
  }
}
