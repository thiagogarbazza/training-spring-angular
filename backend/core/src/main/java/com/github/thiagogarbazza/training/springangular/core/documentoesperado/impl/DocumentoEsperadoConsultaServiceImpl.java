package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperadoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class DocumentoEsperadoConsultaServiceImpl implements DocumentoEsperadoConsultaService {

  @Autowired
  private DocumentoEsperadoRepository documentoEsperadoRepository;

  @Override
  public Collection<DocumentoEsperado> pesquisar() {
    return documentoEsperadoRepository.findAll();
  }
}
