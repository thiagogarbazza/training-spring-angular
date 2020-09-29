package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GrupoDocumentoService4T {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  public void salvar(Collection<GrupoDocumento> grupoDocumentos) {
    grupoDocumentoRepository.saveAll(grupoDocumentos);
  }
}
