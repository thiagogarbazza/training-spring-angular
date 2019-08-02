package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documentodispensado.SituacaoDocumentoDispensado.ATIVO;
import static java.text.MessageFormat.format;
import static java.util.Collections.singleton;

@Component
@CommonsLog
@Order(ProcessadorGerarEsperado.PASSO_BUSCAR_DISPENSAS)
class ProcessadorCarregarDispensa extends ProcessadorGerarEsperado {

  @Autowired
  private DocumentoDispensadoConsultaService documentoDispensadoConsultaService;

  @Override
  public void processar(final DadosGeracaoEsperado dados) {
    final Collection<DocumentoDispensado> documentoDispensados = documentoDispensadoConsultaService.pesquisar(
      DocumentoDispensadoFiltroConsulta.builder()
        .dataBaseInicio(dados.getDataReferencia())
        .dataBaseFim(dados.getDataReferencia())
        .situacoes(singleton(ATIVO))
        .build());

    log.info(format("Existem {0} dispensas para o documento.", documentoDispensados.size()));
    dados.setDocumentoDispensados(documentoDispensados);
  }
}
