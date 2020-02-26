package com.github.thiagogarbazza.training.springangular.utiltest.database;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.EntityManager;

import static org.springframework.transaction.annotation.Isolation.READ_UNCOMMITTED;

@Service
@CommonsLog
public class ResetDatabaseService {

  @Autowired
  private EntityManager entityManager;

  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = READ_UNCOMMITTED, readOnly = false)
  public void reset() {
    entityManager.flush();
    entityManager.createNativeQuery("SET referential_integrity false").executeUpdate();
    tables().forEach(t -> entityManager.createNativeQuery("TRUNCATE TABLE " + t).executeUpdate());
    entityManager.createNativeQuery("SET referential_integrity true").executeUpdate();
  }

  private Collection<String> tables() {
    return Arrays.asList(
      "zzt_test.tbl_simple_entity_object_persistence",
      "zzt_test.tbl_simple_entity_audited_a",
      "zzt_test.tbl_simple_entity_audited_b",
      "zzt_test.tbl_simple_entity_audited_c");
  }
}
