package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GrupoDocumentoServiceImpl implements GrupoDocumentoService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;
}
