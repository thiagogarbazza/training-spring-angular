package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
interface RevisionInformationRepository extends JpaRepository<RevisionInformation, Long> {
}
