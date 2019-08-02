package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.HistoricoSituacaoDocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
class HistoricoSituacaoDocumentoEsperadoRepositoryImpl
  extends CustomQueryDslRepositorySupport<HistoricoSituacaoDocumentoEsperado>
  implements HistoricoSituacaoDocumentoEsperadoRepositoryCustom {

  protected HistoricoSituacaoDocumentoEsperadoRepositoryImpl() {
    super(HistoricoSituacaoDocumentoEsperado.class);
  }
}
