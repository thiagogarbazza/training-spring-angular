package com.github.thiagogarbazza.training.springangular.core.it.jpa;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.transaction.annotation.Isolation.READ_UNCOMMITTED;

@CoreIntegrationTestRunner
class JPARepositoryIntegrationTest {

  @Autowired
  private ClienteConsultaService clienteConsultaService;

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private ResetDatabaseService resetDatabaseService;

  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = READ_UNCOMMITTED, readOnly = false)
  void verificarRepository() {
    resetDatabaseService.reset();

    Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    assertEquals(0, clientes.size());

    final Cliente cliente = clienteService.salvar(Cliente.builder().codigo("TPGV").nome("Thiago Garbazza").build());

    clientes = clienteConsultaService.pesquisar();
    assertEquals(1, clientes.size());
    Cliente clienteRecuperado = IterableUtils.get(clientes, 0);

    assertNotNull(clienteRecuperado.getId());
    assertFalse(clienteRecuperado.isNew());
    assertEquals("TPGV", clienteRecuperado.getCodigo());
    assertEquals("Thiago Garbazza", clienteRecuperado.getNome());

    cliente.setCodigo("TPGV 02");
    cliente.setNome("Thiago de Pádua Garbazza Vieira");
    clienteService.salvar(cliente);

    clientes = clienteConsultaService.pesquisar();
    assertEquals(1, clientes.size());
    clienteRecuperado = IterableUtils.get(clientes, 0);

    assertNotNull(clienteRecuperado.getId());
    assertFalse(clienteRecuperado.isNew());
    assertEquals("TPGV 02", clienteRecuperado.getCodigo());
    assertEquals("Thiago de Pádua Garbazza Vieira", clienteRecuperado.getNome());
  }

  @AfterAll
  static void afterAll() {

  }

  @BeforeAll
  static void beforeAll() {

  }
}
