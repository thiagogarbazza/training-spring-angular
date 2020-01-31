package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RevisionInformationRepository extends JpaRepository<RevisionInformation, Long> {
}
