package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.adapter.calendario.CalendarioAdapter;
import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperadoService;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.HistoricoSituacaoDocumentoEsperado;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

import static com.github.thiagogarbazza.training.springangular.core.documentoesperado.SituacaoDocumentoEsperado.ESPERADO;
import static com.github.thiagogarbazza.training.springangular.core.documentoesperado.SituacaoDocumentoEsperado.NAO_ESPERADO;

@Component
@CommonsLog
@Order(ProcessadorGerarEsperado.PASSO_GERAR_ESPERADO)
class ProcessadorGerarEsperados extends ProcessadorGerarEsperado {

  @Autowired
  private CalendarioAdapter calendarioAdapter;
  @Autowired
  private DocumentoEsperadoService documentoEsperadoService;

  @Override
  public void processar(final DadosGeracaoEsperado dados) {
    for (final Cliente cliente : dados.getClientes()) {
      final DocumentoDispensado documentoDispensado = dados.getDocumentoDispensados().stream()
        .filter(d -> d.getCliente().equals(cliente))
        .findFirst()
        .orElse(null);

      DocumentoEsperado documentoEsperado = DocumentoEsperado.builder()
        .documento(dados.getDocumento())
        .cliente(cliente)
        .dataBase(dados.getDataReferencia())
        .dataLimiteEntrega(calendarioAdapter.calcularDataUtil(dados.getDataReferencia(), 30))
        .situacao(Objects.isNull(documentoDispensado) ? NAO_ESPERADO : ESPERADO)
        .historicoSituacao(new ArrayList<>())
        .build();

      documentoEsperado.getHistoricoSituacao().add(HistoricoSituacaoDocumentoEsperado.builder()
        .documentoEsperado(documentoEsperado)
        .situacao(documentoEsperado.getSituacao())
        .build());

      documentoEsperadoService.gerarEsperado(documentoEsperado);
    }
  }
}
