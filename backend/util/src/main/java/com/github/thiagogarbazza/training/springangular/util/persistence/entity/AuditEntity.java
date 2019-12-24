package com.github.thiagogarbazza.training.springangular.util.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@ToString
@Embeddable
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class AuditEntity {

  private LocalDateTime dateTime;
  private String userName;
}
