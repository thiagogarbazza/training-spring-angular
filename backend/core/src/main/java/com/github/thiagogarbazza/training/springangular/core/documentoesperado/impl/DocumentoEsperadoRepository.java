package com.github.thiagogarbazza.training.springangular.core.documentoesperado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface DocumentoEsperadoRepository extends JpaRepository<DocumentoEsperado, UUID>, DocumentoEsperadoRepositoryCustom {
}
