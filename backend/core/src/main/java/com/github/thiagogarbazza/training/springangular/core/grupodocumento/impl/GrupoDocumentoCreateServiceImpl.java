package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoCreateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.HistoricoSituacaoGrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
class GrupoDocumentoCreateServiceImpl implements GrupoDocumentoCreateService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;
  @Autowired
  private GrupoDocumentoValidation grupoDocumentoValidation;

  @Override
  public GrupoDocumento create(final GrupoDocumentoVO4Create grupoDocumentoVO4Create) {
    grupoDocumentoValidation.onCreate(grupoDocumentoVO4Create);

    final GrupoDocumento grupoDocumento = GrupoDocumento.builder()
      .codigo(grupoDocumentoVO4Create.getCodigo())
      .nome(grupoDocumentoVO4Create.getNome())
      .situacao(SituacaoGrupoDocumento.ATIVO)
      .historicoSituacaoGrupoDocumentos(new ArrayList<>())
      .build();

    grupoDocumento.getHistoricoSituacaoGrupoDocumentos().add(HistoricoSituacaoGrupoDocumento.builder()
      .grupoDocumento(grupoDocumento)
      .situacao(SituacaoGrupoDocumento.ATIVO)
      .build());

    return grupoDocumentoRepository.save(grupoDocumento);
  }
}
