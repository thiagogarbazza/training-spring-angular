package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class GrupoDocumentoServiceImpl implements GrupoDocumentoService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  @Override
  public Optional<GrupoDocumento> findById(final UUID id) {
    return grupoDocumentoRepository.findById(id);
  }
}
