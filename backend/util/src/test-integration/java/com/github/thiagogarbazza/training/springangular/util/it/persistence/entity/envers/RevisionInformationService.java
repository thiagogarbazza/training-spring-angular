package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import javax.persistence.EntityManagerFactory;

@Component
@CommonsLog
class RevisionInformationService {

  @Autowired
  private EntityManagerFactory entityManagerFactory;
  @Autowired
  private RevisionInformationRepository revisionInformationRepository;

  <ID> Long count(final Class clazz, final ID id) {
    return (Long) getAuditReader().createQuery()
      .forRevisionsOfEntity(clazz, false, true)
      .addProjection(AuditEntity.id().count())
      .add(AuditEntity.id().eq(id))
      .getSingleResult();
  }

  <ID, T> T revision(final Class<T> clazz, final ID id, final long revisionId) {
    final Object[] singleResult = (Object[]) getAuditReader().createQuery()
      .forRevisionsOfEntity(clazz, false, true)
      .add(AuditEntity.id().eq(id))
      .add(AuditEntity.revisionNumber().eq(revisionId))
      .getSingleResult();

    //noinspection unchecked
    return (T) singleResult[0];
  }

  <ID> Collection<RevisionInformation> revisions(final Class clazz, final ID id) {
    //noinspection unchecked
    final Collection<Long> revisions = (Collection<Long>) getAuditReader().createQuery()
      .forRevisionsOfEntity(clazz, false, true)
      .addProjection(AuditEntity.revisionNumber())
      .add(AuditEntity.id().eq(id))
      .addOrder(AuditEntity.revisionNumber().asc())
      .getResultList();

    return revisionInformationRepository.findAllById(revisions);
  }

  private AuditReader getAuditReader() {
    return AuditReaderFactory.get(entityManagerFactory.createEntityManager());
  }
}
