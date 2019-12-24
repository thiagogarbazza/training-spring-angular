package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoUpdateService;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class GrupoDocumentoUpdateServiceImpl implements GrupoDocumentoUpdateService {

  @Autowired
  private GrupoDocumentoRepository grupoDocumentoRepository;
  @Autowired
  private GrupoDocumentoValidation grupoDocumentoValidation;

  @Override
  public GrupoDocumento update(final GrupoDocumentoVO4Update grupoDocumentoVO4Update) {
    grupoDocumentoValidation.onUpdate(grupoDocumentoVO4Update);

    final Optional<GrupoDocumento> optionalGrupoDocumento = grupoDocumentoRepository.findById(grupoDocumentoVO4Update.getId());
    if (optionalGrupoDocumento.isPresent()) {
      final GrupoDocumento grupoDocumento = optionalGrupoDocumento.get();
      grupoDocumento.setCodigo(grupoDocumentoVO4Update.getCodigo());
      grupoDocumento.setNome(grupoDocumentoVO4Update.getNome());

      return grupoDocumentoRepository.save(grupoDocumento);
    }

    return null;
  }
}
