package com.github.thiagogarbazza.training.springangular.core.it.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSortableColumns;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.GrupoDocumentoService4TA;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.OrderableDirection;
import com.github.thiagogarbazza.training.springangular.utiltest.database.TruncateDatabaseService;
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
  private GrupoDocumentoService4TA grupoDocumentoService4TA;
  @Autowired
  private TruncateDatabaseService truncateDatabaseService;

  @Test
  void verify() {
    final GrupoDocumentoSearchFilter grupoDocumentoSearchFilter = GrupoDocumentoSearchFilter.builder()
      .codigo("GRP01")
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
