package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import org.hibernate.envers.RevisionListener;

class CustomRevisionInformationListener implements RevisionListener {

  @Override
  public void newRevision(final Object revisionEntity) {
    if (revisionEntity instanceof CustomRevisionInformation) {
      final CustomRevisionInformation customRevisionInformation = (CustomRevisionInformation) revisionEntity;

      customRevisionInformation.setUserName("thiagogarbazza");
    }
  }
}
