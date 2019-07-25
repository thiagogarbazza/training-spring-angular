package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;

import java.util.Collection;

interface ClienteRepositoryCustom {

  Collection<Cliente> pesquisar();
}
