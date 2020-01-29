package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UtilIntegrationTestRunner
class SimpleEntityAudited_AIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private SimpleEntityAudited_ARepository simpleEntityAuditedARepository;

  @BeforeEach
  void beforeEach() {
    resetDatabaseService.reset();
  }

  @Test
  void vefiryAuditedOnCreate() {
    final SimpleEntityAudited_A created_a = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a")
      .description("any-code_a description")
      .build());
  }

  @Test
  void vefiryAuditedOnDelete() {
    final SimpleEntityAudited_A created_a = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a")
      .description("any-code_a description")
      .build());

    simpleEntityAuditedARepository.deleteById(created_a.getId());
  }

  @Test
  void vefiryAuditedOnUpdate() {
    final SimpleEntityAudited_A created_a = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a")
      .description("any-code_a description")
      .build());

    created_a.setDescription("any-code_a description 02");
    simpleEntityAuditedARepository.save(created_a);
  }
}
