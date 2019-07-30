package com.github.thiagogarbazza.training.springangular.core.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class DocumentoDispensadoConsultaServiceImpl implements DocumentoDispensadoConsultaService {

  @Autowired
  private DocumentoDispensadoRepository documentoDispensadoRepository;

  @Override
  public Collection<DocumentoDispensado> pesquisar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoRepository.pesquisar(filtroConsulta);
  }

  @Override
  public CustomPage<DocumentoDispensado> pesquisarPaginando(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    return documentoDispensadoRepository.pesquisarPaginando(filtroConsulta);
  }
}
