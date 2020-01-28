package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UtilIntegrationTestRunner
class SimpleEntityAuditedIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private SimpleEntityAuditedRepository simpleEntityAuditedRepository;

  @BeforeEach
  void beforeEach() {
    resetDatabaseService.reset();
  }

  @Test
  void vefiryAuditedOnCreate() {
    final SimpleEntityAudited created = simpleEntityAuditedRepository.save(SimpleEntityAudited.builder()
      .code("any-code")
      .description("any description 01")
      .build());
  }

  @Test
  void vefiryAuditedOnDelete() {
    final SimpleEntityAudited created = simpleEntityAuditedRepository.save(SimpleEntityAudited.builder()
      .code("any-code")
      .description("any description 01")
      .build());

    simpleEntityAuditedRepository.deleteById(created.getId());
  }

  @Test
  void vefiryAuditedOnUpdate() {
    final SimpleEntityAudited created = simpleEntityAuditedRepository.save(SimpleEntityAudited.builder()
      .code("any-code")
      .description("any description 01")
      .build());

    created.setDescription("any description 02");
    simpleEntityAuditedRepository.save(created);
  }
}
