package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documento.DocumentoFiltroConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class DocumentoConsultaServiceImpl implements DocumentoConsultaService {

  @Autowired
  private DocumentoRepository documentoRepository;

  @Override
  public Collection<Documento> pesquisar(final DocumentoFiltroConsulta filtroConsulta) {
    return documentoRepository.pesquisar(filtroConsulta);
  }
}
