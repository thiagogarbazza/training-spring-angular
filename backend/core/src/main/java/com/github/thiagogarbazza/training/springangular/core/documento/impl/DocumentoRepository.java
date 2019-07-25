package com.github.thiagogarbazza.training.springangular.core.documento.impl;

import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface DocumentoRepository extends JpaRepository<Documento, UUID>, DocumentoRepositoryCustom {
}
