package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoService;
import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForUpdatingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class GrupoDocumentoForUpdatingService {

  @Autowired
  private GrupoDocumentoService grupoDocumentoService;

  GrupoDocumentoForUpdatingVO forUpdating(final UUID id) {
    final Optional<GrupoDocumento> optionalGrupoDocumento = grupoDocumentoService.findById(id);

    if (!optionalGrupoDocumento.isPresent()) {
      return null;
    }

    final GrupoDocumento grupoDocumento = optionalGrupoDocumento.get();

    return GrupoDocumentoForUpdatingVO.builder()
      .formData(GrupoDocumentoForUpdatingVO.FormData.builder()
        .codigo(grupoDocumento.getCodigo())
        .nome(grupoDocumento.getNome())
        .build())
      .build();
  }
}
