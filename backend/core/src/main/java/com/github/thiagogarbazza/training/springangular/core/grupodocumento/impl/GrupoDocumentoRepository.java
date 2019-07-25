package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface GrupoDocumentoRepository extends JpaRepository<GrupoDocumento, UUID>, GrupoDocumentoRepositoryCustom {
}
