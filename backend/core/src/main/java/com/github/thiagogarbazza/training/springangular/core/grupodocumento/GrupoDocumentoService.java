package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import java.util.UUID;

public interface GrupoDocumentoService {

  GrupoDocumento create(GrupoDocumentoVO4Create grupoDocumentoVO4Create);

  void deletar(UUID uuid);

  GrupoDocumento update(GrupoDocumentoVO4Update grupoDocumentoVO4Update);
}
