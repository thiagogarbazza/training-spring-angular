package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_revision_information", schema = "zzt_test")
@RevisionEntity(RevisionInformationListener.class)
class RevisionInformation {

  @Id
  @RevisionNumber
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @RevisionTimestamp
  @Column(name = "timestamp")
  private long timestamp;

  @Column(name = "userName")
  private String userName;
}
