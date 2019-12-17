package com.github.thiagogarbazza.training.springangular.core.it.grupodocumento;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.violationbuilder.ViolationException;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@CoreIntegrationTestRunner
class GrupoDocumentoCreateIntegrationTest {

  @Autowired
  private GrupoDocumentoService grupoDocumentoService;

  @Test
  void verifyCodigoObrigatorio() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      final GrupoDocumentoVO4Create grupoDocumentoVO4Create = GrupoDocumentoVO4Create.builder().nome("Nome GRPDOC-001").build();
      grupoDocumentoService.create(grupoDocumentoVO4Create);
    });

    assertEquals(1, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("grupo-documento.codigo-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'código' deve ser preenchido.", simpleMessage.getContent());
  }

  @Test
  void verifySalvarComSucesso() {
    final GrupoDocumentoVO4Create grupoDocumentoVO4Create = GrupoDocumentoVO4Create.builder().codigo("GRPDOC-001").nome("Nome GRPDOC-001").build();

    final GrupoDocumento grupoDocumento = grupoDocumentoService.create(grupoDocumentoVO4Create);

    assertNotNull(grupoDocumento);
  }
}
