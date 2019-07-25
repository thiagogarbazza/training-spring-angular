package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public Cliente salvar(final Cliente cliente) {
    return clienteRepository.save(cliente);
  }
}
