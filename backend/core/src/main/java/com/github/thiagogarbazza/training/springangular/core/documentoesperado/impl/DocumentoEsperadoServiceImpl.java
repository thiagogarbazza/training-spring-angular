package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class DocumentoEsperadoServiceImpl implements DocumentoEsperadoService {

  @Autowired
  private DocumentoEsperadoRepository documentoEsperadoRepository;

  @Override
  public void gerarEsperado(final DocumentoEsperado documentoEsperado) {
    documentoEsperadoRepository.save(documentoEsperado);
  }
}
