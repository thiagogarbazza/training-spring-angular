package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import java.util.Collection;

public interface GrupoDocumentoConsultaService {

  Collection<GrupoDocumento> pesquisar(GrupoDocumentoFiltroConsulta filtroConsulta);
}
