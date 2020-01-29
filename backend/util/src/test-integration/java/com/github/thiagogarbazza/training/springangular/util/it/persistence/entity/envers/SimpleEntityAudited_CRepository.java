package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface SimpleEntityAudited_CRepository extends JpaRepository<SimpleEntityAudited_C, UUID> {
}
