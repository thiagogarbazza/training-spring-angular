package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoFiltroConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class GrupoDocumentoConsultaServiceImpl implements GrupoDocumentoConsultaService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  @Override
  public Collection<GrupoDocumento> pesquisar(final GrupoDocumentoFiltroConsulta filtroConsulta) {
    return grupoDocumentoRepository.pesquisar(filtroConsulta);
  }
}
