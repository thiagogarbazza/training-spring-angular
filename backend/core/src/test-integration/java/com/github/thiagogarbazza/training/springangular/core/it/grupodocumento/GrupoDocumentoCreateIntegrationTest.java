package com.github.thiagogarbazza.training.springangular.core.it.grupodocumento;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoCreateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import com.github.thiagogarbazza.training.springangular.utiltest.stub.ResetStubService;
import com.github.thiagogarbazza.violationbuilder.ViolationException;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@CoreIntegrationTestRunner
class GrupoDocumentoCreateIntegrationTest {

  @Autowired
  private GrupoDocumentoCreateService grupoDocumentoCreateService;
  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private ResetStubService resetStubService;

  @BeforeEach
  void beforeEach() {
    resetDatabaseService.reset();
    resetStubService.reset();
  }

  @Test
  void verifyCodigoObrigatorio() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      final GrupoDocumentoVO4Create grupoDocumentoVO4Create = GrupoDocumentoVO4Create.builder().nome("Nome GRPDOC-001").build();
      grupoDocumentoCreateService.create(grupoDocumentoVO4Create);
    });

    assertEquals(1, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("grupo-documento.codigo-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'código' deve ser preenchido.", simpleMessage.getContent());
  }

  @Test
  void verifySalvarComSucesso() {
    final GrupoDocumentoVO4Create grupoDocumentoVO4Create = GrupoDocumentoVO4Create.builder().codigo("GRPDOC-001").nome("Nome GRPDOC-001").build();

    final GrupoDocumento grupoDocumento = grupoDocumentoCreateService.create(grupoDocumentoVO4Create);

    assertNotNull(grupoDocumento);
    assertEquals("GRPDOC-001", grupoDocumento.getCodigo());
    assertEquals("Nome GRPDOC-001", grupoDocumento.getNome());
    assertNotNull(grupoDocumento.getCreation());
    assertNotNull(grupoDocumento.getCreation().getUserName());
    assertNotNull(grupoDocumento.getCreation().getDateTime());
  }
}
