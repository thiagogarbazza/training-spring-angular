package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoCreateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
      .build();

    return grupoDocumentoRepository.save(grupoDocumento);
  }
}
