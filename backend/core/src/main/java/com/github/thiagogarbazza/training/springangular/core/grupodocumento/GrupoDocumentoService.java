package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import java.util.Optional;
import java.util.UUID;

public interface GrupoDocumentoService {

  Optional<GrupoDocumento> findById(UUID id);

}
