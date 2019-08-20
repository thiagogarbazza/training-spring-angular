package com.github.thiagogarbazza.training.springangular.core.it.jpa;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.TruncateDatabaseService;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.READ_UNCOMMITTED;

@CoreIntegrationTestRunner
class TransactionalIsolationReadCommittedIntegrationTest {

  @Autowired
  private ClienteConsultaService clienteConsultaService;

  @Autowired
  private ClienteService clienteService;

  @Autowired
  private TruncateDatabaseService truncateDatabaseService;

  @BeforeEach
  void beforeEach(){
    truncateDatabaseService.truncate();
  }

  @Test
  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = READ_COMMITTED, readOnly = false)
  void verificarTransacaoComIsolationReadCommitted() {
    Collection<Cliente> clientes = clienteConsultaService.pesquisar();
    assertEquals(0, clientes.size());

    final Cliente cliente = clienteService.salvar(Cliente.builder().codigo("TPGV").nome("Thiago Garbazza").build());

    clientes = clienteConsultaService.pesquisar();
    assertEquals(1, clientes.size());
  }

}
