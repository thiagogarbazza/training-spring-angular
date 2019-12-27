package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.Getter;

@Getter
public enum Periodicidade implements EnumIdentifiableWithDescription<Integer> {

  DIARIA(1, "Diário"),
  SEMANAL(2, "Semanal"),
  QUINZENAL(3, "Quinzenal"),
  MENSAL(4, "Mensal"),
  BIMESTRAL(5, "Bimestral"),
  TRIMESTRAL(6, "Trimestral"),
  SEMESTRAL(7, "Semestral"),
  ANUAL(8, "Anual"),
  REGRA(255, "Regra");

  private final Integer id;
  private final String description;

  Periodicidade(final int id, final String description) {
    this.id = id;
    this.description = description;
  }
}
