package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
class GrupoDocumentoDeleteServiceImpl implements GrupoDocumentoDeleteService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;

  @Override
  public void delete(final UUID uuid) {
    grupoDocumentoRepository.deleteById(uuid);
  }
}
