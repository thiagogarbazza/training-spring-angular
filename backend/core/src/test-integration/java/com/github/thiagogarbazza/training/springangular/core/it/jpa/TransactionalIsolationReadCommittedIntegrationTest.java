package com.github.thiagogarbazza.training.springangular.core.it.jpa;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import com.github.thiagogarbazza.training.springangular.core.it.CoreIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@CoreIntegrationTestRunner
class TransactionalIsolationReadCommittedIntegrationTest {

  @Autowired
  private ClienteConsultaService clienteConsultaService;
  @Autowired
  private ClienteService clienteService;
  @Autowired
  private ResetDatabaseService resetDatabaseService;

  @BeforeEach
  void beforeEach(){
    resetDatabaseService.reset();
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
