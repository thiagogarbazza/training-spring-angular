package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.HistoricoSituacaoDocumentoEsperado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface HistoricoSituacaoDocumentoEsperadoRepository
  extends JpaRepository<HistoricoSituacaoDocumentoEsperado, UUID>, HistoricoSituacaoDocumentoEsperadoRepositoryCustom {
}
