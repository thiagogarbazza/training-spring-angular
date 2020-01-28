package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.objectpersistent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface SimpleEntityObjectPersistenteRepository extends JpaRepository<SimpleEntityObjectPersistente, UUID> {
}
