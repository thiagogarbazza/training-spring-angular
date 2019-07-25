package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ClienteRepository extends JpaRepository<Cliente, UUID>, ClienteRepositoryCustom {
}
