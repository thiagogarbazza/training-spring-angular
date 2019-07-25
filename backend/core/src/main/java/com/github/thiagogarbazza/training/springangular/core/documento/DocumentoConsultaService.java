package com.github.thiagogarbazza.training.springangular.core.documento;

import java.util.Collection;

public interface DocumentoConsultaService {

  Collection<Documento> pesquisar(DocumentoFiltroConsulta filtroConsulta);
}
