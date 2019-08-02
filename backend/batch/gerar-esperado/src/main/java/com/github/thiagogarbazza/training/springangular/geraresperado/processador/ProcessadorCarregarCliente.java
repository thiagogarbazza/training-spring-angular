package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.cliente.ClienteConsultaService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static java.text.MessageFormat.format;

@Component
@CommonsLog
@Order(ProcessadorGerarEsperado.PASSO_BUSCAR_CLIENTE)
class ProcessadorCarregarCliente extends ProcessadorGerarEsperado {

  @Autowired
  private ClienteConsultaService clienteConsultaService;

  @Override
  public void processar(final DadosGeracaoEsperado dados) {
    final Collection<Cliente> clientes = clienteConsultaService.pesquisar();

    log.info(format("Existem {0} clientes para serem gerados esperados.", clientes.size()));
    dados.setClientes(clientes);
  }
}
