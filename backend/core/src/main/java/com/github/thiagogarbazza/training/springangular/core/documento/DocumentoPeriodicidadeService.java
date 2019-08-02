package com.github.thiagogarbazza.training.springangular.core.documento;

import java.time.LocalDate;

public interface DocumentoPeriodicidadeService {

  boolean dataReferenciaEEsperada(Documento documento, LocalDate dataReferencia);
}
