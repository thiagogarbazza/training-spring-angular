package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.batchcomum.processamento.InterromperProcessadorException;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoPeriodicidadeService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static com.github.thiagogarbazza.training.springangular.util.lang.BooleanUtil.booleanToString;
import static java.text.MessageFormat.format;

@Component
@CommonsLog
@Order(ProcessadorGerarEsperado.PASSO_VERIFICAR_DATA_REFERENCIA)
class ProcessadorVerificarDataReferencia extends ProcessadorGerarEsperado {

  @Autowired
  private DocumentoPeriodicidadeService documentoPeriodicidadeService;

  @Override
  public void processar(final DadosGeracaoEsperado dados) {
    final Documento documento = dados.getDocumento();
    final boolean dataReferenciaEEsperada = documentoPeriodicidadeService.dataReferenciaEEsperada(documento, dados.getDataReferencia());

    if (!dataReferenciaEEsperada) {
      throw new InterromperProcessadorException(format("O documento {0} {1} é esperado para a data referência.",
        documento.getCodigo(), booleanToString(dataReferenciaEEsperada).toLowerCase()));
    }
  }
}
