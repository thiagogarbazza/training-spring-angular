package com.github.thiagogarbazza.training.springangular.core.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;

import java.util.Collection;

interface DocumentoDispensadoRepositoryCustom {

  Collection<DocumentoDispensado> pesquisar(DocumentoDispensadoFiltroConsulta filtroConsulta);

  CustomPage<DocumentoDispensado> pesquisarPaginando(DocumentoDispensadoFiltroConsulta filtroConsulta);
}
