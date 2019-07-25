package com.github.thiagogarbazza.training.springangular.util.persistence.integrator;

import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.usertype.UserType;

import static java.text.MessageFormat.format;
import static java.util.Arrays.asList;

@CommonsLog
public class HibernateIntegrator implements Integrator {

  @Override
  public void integrate(final Metadata metadata, final SessionFactoryImplementor sessionFactory, final SessionFactoryServiceRegistry serviceRegistry) {
    if (metadata instanceof MetadataImplementor) {
      final MetadataImplementor metadataImplementor = (MetadataImplementor) metadata;
      autoRegisterCompositeUserType(metadataImplementor);
      autoRegisterUsertypes(metadataImplementor);
    } else {
      throw new IllegalArgumentException("Metadata was not assignable to MetadataImplementor: " + metadata.getClass());
    }
  }

  @Override
  public void disintegrate(final SessionFactoryImplementor sessionFactory, final SessionFactoryServiceRegistry serviceRegistry) {

  }

  private void autoRegisterCompositeUserType(MetadataImplementor metadataImplementor) {
   /* for (CompositeUserType userType : asList(new TestCompositeUserType())) {
      log.trace(format("Register hibernate user type {0}.", userType.getClass()));
      metadataImplementor.getTypeResolver().registerTypeOverride(userType, new String[] {userType.returnedClass().getName()});
    }*/
  }

  private void autoRegisterUsertypes(MetadataImplementor metadataImplementor) {
    for (UserType userType : asList(new StringTrimmedType())) {
      log.trace(format("Register hibernate user type {0}.", userType.getClass()));
      metadataImplementor.getTypeResolver().registerTypeOverride(userType, new String[] {userType.returnedClass().getName()});
    }
  }
}
