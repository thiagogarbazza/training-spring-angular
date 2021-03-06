package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.CustomQuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
class DocumentoEsperadoRepositoryImpl extends CustomQuerydslRepositorySupport<DocumentoEsperado> implements DocumentoEsperadoRepositoryCustom {

  protected DocumentoEsperadoRepositoryImpl() {
    super(DocumentoEsperado.class);
  }
}
