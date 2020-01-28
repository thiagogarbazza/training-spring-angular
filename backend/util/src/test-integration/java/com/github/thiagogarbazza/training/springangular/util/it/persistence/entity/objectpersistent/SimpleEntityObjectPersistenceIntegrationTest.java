package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.objectpersistent;

import com.github.thiagogarbazza.training.springangular.util.it.UtilIntegrationTestRunner;
import com.github.thiagogarbazza.training.springangular.utiltest.database.ResetDatabaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Optional;

import static com.github.thiagogarbazza.training.springangular.util.it.commons.UUIDD4T.ID_91357977_0c4c_4ac2_b3a7_7f35053aa4d3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UtilIntegrationTestRunner
class SimpleEntityObjectPersistenceIntegrationTest {

  @Autowired
  private ResetDatabaseService resetDatabaseService;
  @Autowired
  private SimpleEntityObjectPersistenteRepository simpleEntityObjectPersistenteRepository;

  @BeforeEach
  void beforeEach() {
    resetDatabaseService.reset();
  }

  @Test
  void vefiryCreate() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .code("any code")
      .build());

    assertNotNull(created);
    assertNotNull(created.getId());
    assertEquals("any code", created.getCode());
  }

  @Test
  void vefiryCreateWithFixedID() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .id(ID_91357977_0c4c_4ac2_b3a7_7f35053aa4d3)
      .code("any code")
      .build());

    assertNotNull(created);
    assertEquals(ID_91357977_0c4c_4ac2_b3a7_7f35053aa4d3, created.getId());
    assertEquals("any code", created.getCode());
  }

  @Test
  void vefiryUpdate() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .code("any code")
      .build());

    assertNotNull(created);
    assertNotNull(created.getId());
    assertEquals("any code", created.getCode());

    created.setCode("any code 2");

    final SimpleEntityObjectPersistente updated = simpleEntityObjectPersistenteRepository.save(created);

    assertNotNull(updated);
    assertNotNull(updated.getId());
    assertEquals(created.getId(), updated.getId());
    assertEquals("any code 2", updated.getCode());
  }

  @Test
  void verifyDelete() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .code("any code")
      .build());

    assertEquals(1, simpleEntityObjectPersistenteRepository.findAll().size());

    simpleEntityObjectPersistenteRepository.deleteById(created.getId());

    assertIterableEquals(Collections.emptyList(), simpleEntityObjectPersistenteRepository.findAll());
  }

  @Test
  void verifyFindAllEmpty() {
    assertIterableEquals(Collections.emptyList(), simpleEntityObjectPersistenteRepository.findAll());
  }

  @Test
  void verifyFindById() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .code("any code")
      .build());

    final Optional<SimpleEntityObjectPersistente> optional = simpleEntityObjectPersistenteRepository.findById(created.getId());
    assertTrue(optional.isPresent());

    final SimpleEntityObjectPersistente simpleEntityObjectPersistente = optional.get();
    assertNotNull(simpleEntityObjectPersistente);
    assertEquals(created.getId(), simpleEntityObjectPersistente.getId());
    assertEquals(created.getCode(), simpleEntityObjectPersistente.getCode());
  }

  @Test
  void verifyFindByIdNonPresent() {
    final SimpleEntityObjectPersistente created = simpleEntityObjectPersistenteRepository.save(SimpleEntityObjectPersistente.builder()
      .code("any code")
      .build());

    Optional<SimpleEntityObjectPersistente> optional = simpleEntityObjectPersistenteRepository.findById(ID_91357977_0c4c_4ac2_b3a7_7f35053aa4d3);
    assertFalse(optional.isPresent());
  }
}
