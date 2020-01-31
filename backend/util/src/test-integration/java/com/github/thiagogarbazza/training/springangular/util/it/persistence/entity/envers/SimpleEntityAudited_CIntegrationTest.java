package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@UtilIntegrationTestRunner
class SimpleEntityAudited_CIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private SimpleEntityAudited_ARepository simpleEntityAuditedARepository;
  @Autowired
  private SimpleEntityAudited_BRepository simpleEntityAuditedBRepository;
  @Autowired
  private SimpleEntityAudited_CRepository simpleEntityAuditedCRepository;

  @Autowired
  private RevisionInformationService revisionInformationService;


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

    final SimpleEntityAudited_B created_b_1 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_1")
      .description("any-code_b_1 description")
      .simpleEntityAuditedA(created_a)
      .build());

    final SimpleEntityAudited_B created_b_2 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_2")
      .description("any-code_b_2 description")
      .simpleEntityAuditedA(created_a)
      .build());

    final SimpleEntityAudited_C created_c = simpleEntityAuditedCRepository.save(SimpleEntityAudited_C.builder()
      .code("any-code_c")
      .description("any-code_c description")
      .simpleEntityAuditedA(created_a)
      .simpleEntityAuditedBS(asList(created_b_1, created_b_2))
      .build());

    Assertions.assertEquals(1L, revisionInformationService.count(created_c.getClass(), created_c.getId()));
  }

  @Test
  void vefiryAuditedOnDelete() {
    final SimpleEntityAudited_A created_a = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code_a")
      .description("any-code_a description")
      .build());

    final SimpleEntityAudited_B created_b_1 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_1")
      .description("any-code_b_1 description")
      .simpleEntityAuditedA(created_a)
      .build());

    final SimpleEntityAudited_B created_b_2 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_2")
      .description("any-code_b_2 description")
      .simpleEntityAuditedA(created_a)
      .build());

    final SimpleEntityAudited_C created_c = simpleEntityAuditedCRepository.save(SimpleEntityAudited_C.builder()
      .code("any-code_c")
      .description("any-code_c description")
      .simpleEntityAuditedA(created_a)
      .simpleEntityAuditedBS(asList(created_b_1, created_b_2))
      .build());

    simpleEntityAuditedCRepository.deleteById(created_c.getId());
    Assertions.assertEquals(2L, revisionInformationService.count(created_c.getClass(), created_c.getId()));
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

    final SimpleEntityAudited_B created_b_1 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_1")
      .description("any-code_b_1 description")
      .simpleEntityAuditedA(created_a_1)
      .build());

    final SimpleEntityAudited_B created_b_2 = simpleEntityAuditedBRepository.save(SimpleEntityAudited_B.builder()
      .code("any-code_b_2")
      .description("any-code_b_2 description")
      .simpleEntityAuditedA(created_a_2)
      .build());

    final SimpleEntityAudited_C created_c = simpleEntityAuditedCRepository.save(SimpleEntityAudited_C.builder()
      .code("any-code_c")
      .description("any-code_c description")
      .simpleEntityAuditedA(created_a_1)
      .simpleEntityAuditedBS(asList(created_b_1, created_b_2))
      .build());

    created_c.setDescription("any-code_c description 02");
    created_c.setSimpleEntityAuditedBS(singletonList(created_b_2));
    created_c.setSimpleEntityAuditedA(created_a_2);

    simpleEntityAuditedCRepository.save(created_c);
    Assertions.assertEquals(2L, revisionInformationService.count(created_c.getClass(), created_c.getId()));
  }
}
