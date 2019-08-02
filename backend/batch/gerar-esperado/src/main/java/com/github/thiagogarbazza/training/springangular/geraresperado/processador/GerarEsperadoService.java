package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.batchcomum.processamento.InterromperProcessadorException;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.github.thiagogarbazza.training.springangular.core.documento.SituacaoDocumento.ATIVO;
import static com.github.thiagogarbazza.training.springangular.core.documento.SituacaoDocumento.ENCERRADO;
import static java.util.Arrays.asList;

@Service
@CommonsLog
public class GerarEsperadoService {

  @Autowired
  private DocumentoConsultaService documentoConsultaService;
  @Autowired
  private List<ProcessadorGerarEsperado> processadores;

  public void processar(final LocalDate dataReferencia) {
    final Collection<Documento> documentos = documentoConsultaService.pesquisar(DocumentoFiltroConsulta.builder().situacoes(asList(ATIVO, ENCERRADO)).build());

    for (final Documento documento : documentos) {
      processar(dataReferencia, documento);
    }
  }

  private void processar(final LocalDate dataReferencia, final Documento documento) {
    DadosGeracaoEsperado dados = DadosGeracaoEsperado.builder()
      .dataReferencia(dataReferencia)
      .documento(documento)
      .build();

    try {
      for (ProcessadorGerarEsperado processador : processadores) {
        processador.processar(dados);
      }
    } catch (InterromperProcessadorException e) {
      log.warn(e.getMessage());
    }
  }
}
