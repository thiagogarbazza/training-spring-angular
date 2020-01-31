package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UtilIntegrationTestRunner
class RevisionInformationServiceIntegrationTest {

  @Autowired
  private RevisionInformationService revisionInformationService;
  @Autowired
  private SimpleEntityAudited_ARepository simpleEntityAuditedARepository;

  @Test
  void verifyAuditedOnCreate() {
    final SimpleEntityAudited_A value1 = buildValue1();
    final SimpleEntityAudited_A value2 = buildValue2();

    assertEquals(5L, revisionInformationService.count(value1.getClass(), value1.getId()));
    assertEquals(4L, revisionInformationService.count(value2.getClass(), value2.getId()));
    assertEquals(0L, revisionInformationService.count(value2.getClass(), UUID.randomUUID()));

    final Collection<RevisionInformation> revisions = revisionInformationService.revisions(value2.getClass(), value2.getId());
    assertEquals(4, revisions.size());

    final SimpleEntityAudited_A value2Versao1 = revisionInformationService.revision(value2.getClass(), value2.getId(),
      IterableUtils.get(revisions, 0).getId());
    assertEquals("any-code-2 description 01", value2Versao1.getDescription());
  }

  private SimpleEntityAudited_A buildValue1() {
    final SimpleEntityAudited_A value = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code-1")
      .description("any-code-1 description 01")
      .build());

    value.setDescription("any-code-1 description 02");
    simpleEntityAuditedARepository.save(value);

    value.setDescription("any-code-1 description 03");
    simpleEntityAuditedARepository.save(value);

    value.setDescription("any-code-1 description 04");
    simpleEntityAuditedARepository.save(value);

    simpleEntityAuditedARepository.deleteById(value.getId());

    return value;
  }

  private SimpleEntityAudited_A buildValue2() {
    final SimpleEntityAudited_A value = simpleEntityAuditedARepository.save(SimpleEntityAudited_A.builder()
      .code("any-code-2")
      .description("any-code-2 description 01")
      .build());

    value.setDescription("any-code-2 description 02");
    simpleEntityAuditedARepository.save(value);

    value.setDescription("any-code-2 description 03");
    simpleEntityAuditedARepository.save(value);

    value.setDescription("any-code-2 description 04");
    simpleEntityAuditedARepository.save(value);

    return value;
  }
}
