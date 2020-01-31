package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UtilIntegrationTestRunner
class SimpleEntityAudited_AIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private RevisionInformationService revisionInformationService;
  @Autowired
  private SimpleEntityAudited_ARepository simpleEntityAuditedARepository;

  @BeforeEach
  void beforeEach() {
    resetDatabaseService.reset();
  }

  @Test
  void vefiryAuditedOnCreate() {
    final SimpleEntityAudited_A created_a_1 = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a_1")
      .description("any-code_a description 01")
      .build());

    final SimpleEntityAudited_A created_a_2 = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a_2")
      .description("any-code_a_2 description 02")
      .build());

    Assertions.assertEquals(1L, revisionInformationService.count(created_a_1.getClass(), created_a_1.getId()));
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
