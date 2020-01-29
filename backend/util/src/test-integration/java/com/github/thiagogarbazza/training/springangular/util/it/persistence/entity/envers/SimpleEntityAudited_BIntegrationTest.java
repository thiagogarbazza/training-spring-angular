package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@UtilIntegrationTestRunner
class SimpleEntityAudited_BIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private SimpleEntityAudited_ARepository simpleEntityAuditedARepository;
  @Autowired
  private SimpleEntityAudited_BRepository simpleEntityAuditedBRepository;

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

    final SimpleEntityAudited_B created_b = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b")
      .description("any-code_b description")
      .simpleEntityAuditedA(created_a)
      .build());
  }

  @Test
  void vefiryAuditedOnDelete() {
    final SimpleEntityAudited_A created_a = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a")
      .description("any-code_a description")
      .build());

    final SimpleEntityAudited_B created_b = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b")
      .description("any-code_b description")
      .simpleEntityAuditedA(created_a)
      .build());

    simpleEntityAuditedBRepository.deleteById(created_b.getId());
  }

  @Test
  void vefiryAuditedOnUpdate() {
    final SimpleEntityAudited_A created_a_1 = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a_1")
      .description("any-code_a_1 description")
      .build());

    final SimpleEntityAudited_A created_a_2 = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a_2")
      .description("any-code_a_2 description")
      .build());

    final SimpleEntityAudited_B created_b = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b")
      .description("any-code_b description")
      .simpleEntityAuditedA(created_a_1)
      .build());

    created_b.setDescription("any-code_b description 02");
    created_b.setSimpleEntityAuditedA(created_a_2);
    simpleEntityAuditedBRepository.save(created_b);
  }
}
