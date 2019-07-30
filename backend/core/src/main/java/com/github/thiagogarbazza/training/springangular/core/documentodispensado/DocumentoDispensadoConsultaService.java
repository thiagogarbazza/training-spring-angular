package com.github.thiagogarbazza.training.springangular.core.documentodispensado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

public interface DocumentoDispensadoConsultaService {

  Collection<DocumentoDispensado> pesquisar(DocumentoDispensadoFiltroConsulta filtroConsulta);

  CustomPage<DocumentoDispensado> pesquisarPaginando(DocumentoDispensadoFiltroConsulta filtroConsulta);
}
