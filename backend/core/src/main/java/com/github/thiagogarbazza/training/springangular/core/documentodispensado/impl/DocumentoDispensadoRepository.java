package com.github.thiagogarbazza.training.springangular.core.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface DocumentoDispensadoRepository extends JpaRepository<DocumentoDispensado, UUID>, DocumentoDispensadoRepositoryCustom {
}
