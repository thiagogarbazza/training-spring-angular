package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.cliente.QCliente.cliente;

@Repository
class ClienteRepositoryImpl extends CustomQueryDslRepositorySupport<Cliente> implements ClienteRepositoryCustom {

  protected ClienteRepositoryImpl() {
    super(Cliente.class);
  }

  @Override
  public Collection<Cliente> pesquisar() {
    return from(cliente)
      .orderBy(cliente.nome.asc())
      .fetch();
  }
}
