package com.github.thiagogarbazza.training.springangular.util.it.persistence.entity.envers;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_revision_information", schema = "zzt_test")
@RevisionEntity(CustomRevisionInformationListener.class)
class CustomRevisionInformation {

  @Id
  @GeneratedValue
  @RevisionNumber
  @Column(name = "id")
  private int id;

  @RevisionTimestamp
  @Column(name = "timestamp")
  private long timestamp;

  @Column(name = "userName")
  private String userName;
}
