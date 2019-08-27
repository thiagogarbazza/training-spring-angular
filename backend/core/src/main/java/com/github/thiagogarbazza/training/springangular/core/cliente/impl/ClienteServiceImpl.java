package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.CLienteNovoVO;
import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;
  @Autowired
  private ClienteValidador clienteValidador;

  @Override
  public Cliente criar(final CLienteNovoVO cLienteNovoVO) {
    clienteValidador.aoCriar(cLienteNovoVO);

    final Cliente cliente = Cliente.builder()
      .codigo(cLienteNovoVO.getCodigo())
      .nome(cLienteNovoVO.getNome())
      .build();

    return salvar(cliente);
  }

  @Override
  public Cliente salvar(final Cliente cliente) {
    return clienteRepository.save(cliente);
  }
}
