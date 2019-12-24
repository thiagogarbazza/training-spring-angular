package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDetailService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Detail;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.HistoricoSituacaoGrupoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
class GrupoDocumentoDetailServiceImpl implements GrupoDocumentoDetailService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  @Override
  @Transactional(readOnly = true)
  public GrupoDocumentoVO4Detail detail(final UUID uuid) {
    final Optional<GrupoDocumento> grupoDocumentoOptional = grupoDocumentoRepository.findById(uuid);

    if (!grupoDocumentoOptional.isPresent()) {
      return null;
    }

    final GrupoDocumento grupoDocumento = grupoDocumentoOptional.get();

    return GrupoDocumentoVO4Detail.builder()
      .id(grupoDocumento.getId())
      .codigo(grupoDocumento.getCodigo())
      .nome(grupoDocumento.getNome())
      .situacao(grupoDocumento.getSituacao())
      .creation(grupoDocumento.getCreation())
      .modification(grupoDocumento.getModification())
      .historicoSituacaos(historicoConverter(grupoDocumento.getHistoricoSituacaoGrupoDocumentos()))
      .build();
  }

  private Collection<GrupoDocumentoVO4Detail.HistoricoSituacao> historicoConverter(
    final Collection<HistoricoSituacaoGrupoDocumento> historicoSituacaoGrupoDocumentos) {
    return historicoSituacaoGrupoDocumentos.stream()
      .map(h -> GrupoDocumentoVO4Detail.HistoricoSituacao.builder()
        .id(h.getId())
        .situacao(h.getSituacao())
        .motivo(h.getMotivo())
        .creation(h.getCreation())
        .build())
      .collect(toList());
  }
}
