package com.github.thiagogarbazza.training.springangular.core.it.grupodocumento;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoUpdateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.violationbuilder.ViolationException;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@CoreIntegrationTestRunner
class GrupoDocumentoUpdateIntegrationTest {

  @Autowired
  private GrupoDocumentoUpdateService grupoDocumentoUpdateService;

  @Test
  void verifyCodigoObrigatorio() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      final GrupoDocumentoVO4Update grupoDocumentoVO4Update = GrupoDocumentoVO4Update.builder()
        .id(UUID.fromString("9c7e6443-a593-4b09-8b6d-f530c3f6ce80"))
        .nome("Novo nome GRPDOC-001")
        .build();

      grupoDocumentoUpdateService.update(grupoDocumentoVO4Update);
    });

    assertEquals(1, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("grupo-documento.codigo-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'código' deve ser preenchido.", simpleMessage.getContent());
  }

  @Test
  void verifySalvarComSucesso() {
    final GrupoDocumentoVO4Update grupoDocumentoVO4Update = GrupoDocumentoVO4Update.builder()
      .id(UUID.fromString("9c7e6443-a593-4b09-8b6d-f530c3f6ce80"))
      .codigo("NOVO_COD")
      .nome("Novo nome GRPDOC-001")
      .build();

    final GrupoDocumento grupoDocumento = grupoDocumentoUpdateService.update(grupoDocumentoVO4Update);

    assertNotNull(grupoDocumento);
    assertEquals("NOVO_COD", grupoDocumento.getCodigo());
    assertEquals("Novo nome GRPDOC-001", grupoDocumento.getNome());
    assertNotNull(grupoDocumento.getModification());
    assertNotNull(grupoDocumento.getModification().getUserName());
    assertNotNull(grupoDocumento.getModification().getDateTime());
  }
}
