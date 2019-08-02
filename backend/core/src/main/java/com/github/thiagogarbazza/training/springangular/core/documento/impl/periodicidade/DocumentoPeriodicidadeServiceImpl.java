package com.github.thiagogarbazza.training.springangular.core.documento.impl.periodicidade;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoPeriodicidadeService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
class DocumentoPeriodicidadeServiceImpl implements DocumentoPeriodicidadeService {

  @Override
  public boolean dataReferenciaEEsperada(final Documento documento, final LocalDate dataReferencia) {
    return true;
  }
}
