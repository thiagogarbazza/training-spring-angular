package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import lombok.Getter;

@Getter
public enum Periodicidade implements EnumIdentifiableWithNome {

  DIARIA(1, "Diário"),
  SEMANAL(2, "Semanal"),
  QUINZENAL(3, "Quinzenal"),
  MENSAL(4, "Mensal"),
  BIMESTRAL(5, "Bimestral"),
  TRIMESTRAL(6, "Trimestral"),
  SEMESTRAL(7, "Semestral"),
  ANUAL(8, "Anual"),
  REGRA(255, "Regra");

  private final int id;
  private final String nome;

  Periodicidade(final int id, final String nome) {
    this.id = id;
    this.nome = nome;
  }
}
