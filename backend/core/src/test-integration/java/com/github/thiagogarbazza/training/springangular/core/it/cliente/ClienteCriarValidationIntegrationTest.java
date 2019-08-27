package com.github.thiagogarbazza.training.springangular.core.it.cliente;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.training.springangular.core.cliente.CLienteNovoVO;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.violationbuilder.ViolationException;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@CoreIntegrationTestRunner
public class ClienteCriarValidationIntegrationTest {

  @Autowired
  private ClienteService clienteService;

  @Test
  void verificarAcumulado() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      clienteService.criar(CLienteNovoVO.builder().build());
    });

    assertEquals(2, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("cliente.codigo-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'código' deve ser preenchido.", simpleMessage.getContent());
    simpleMessage = IterableUtils.get(violationException.getViolations(), 1);
    assertEquals("cliente.nome-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'nome' deve ser preenchido.", simpleMessage.getContent());
  }

  @Test
  void verificarCodigoObrigatorio() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      clienteService.criar(CLienteNovoVO.builder().nome("Nome qualquer.").build());
    });

    assertEquals(1, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("cliente.codigo-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'código' deve ser preenchido.", simpleMessage.getContent());
  }

  @Test
  void verificarNomeObrigatorio() {
    final ViolationException violationException = assertThrows(ViolationException.class, () -> {
      clienteService.criar(CLienteNovoVO.builder().codigo("código qualquer.").build());
    });

    assertEquals(1, violationException.getViolations().size());
    SimpleMessage simpleMessage = IterableUtils.get(violationException.getViolations(), 0);
    assertEquals("cliente.nome-obrigatorio", simpleMessage.getKey());
    assertEquals("O campo 'nome' deve ser preenchido.", simpleMessage.getContent());
  }
}
