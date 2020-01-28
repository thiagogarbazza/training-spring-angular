package com.github.thiagogarbazza.training.springangular.utiltest.database;

import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.Metamodel;
import org.hibernate.Session;
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
    Collection<String> tableNames = Arrays.asList("zzt_test.tbl_simple_entity_object_persistence", "zzt_test.tbl_simple_entity_audited");
    Session session = entityManager.unwrap(Session.class);
    Metamodel hibernateMetadata = session.getSessionFactory().getMetamodel();

    //for (ClassMetadata classMetadata : hibernateMetadata.values()) {
    // AbstractEntityPersister aep = (AbstractEntityPersister) classMetadata;
    //tableNames.add(aep.getTableName());
    // }

    entityManager.flush();
    entityManager.createNativeQuery("SET referential_integrity false").executeUpdate();
    tableNames.forEach(tableName -> entityManager.createNativeQuery("TRUNCATE TABLE " + tableName).executeUpdate());
    entityManager.createNativeQuery("SET referential_integrity true").executeUpdate();
  }
}
