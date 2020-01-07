package com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento;

import com.github.thiagogarbazza.training.springangular.rest.controller.grupodocumento.resource.GrupoDocumentoForCreatingVO;
import org.springframework.stereotype.Service;

@Service
class GrupoDocumentoForCreatingService {

  GrupoDocumentoForCreatingVO forCreating() {
    return GrupoDocumentoForCreatingVO.builder()
      .formData(GrupoDocumentoForCreatingVO.FormData.builder()
        .codigo(null)
        .nome(null)
        .build())
      .build();
  }
}
