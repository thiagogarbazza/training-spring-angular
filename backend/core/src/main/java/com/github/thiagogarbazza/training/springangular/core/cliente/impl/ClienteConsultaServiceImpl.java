package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class ClienteConsultaServiceImpl implements ClienteConsultaService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public Collection<Cliente> pesquisar() {
    return clienteRepository.pesquisar();
  }
}
