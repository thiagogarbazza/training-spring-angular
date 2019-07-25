package com.github.thiagogarbazza.training.springangular.util.persistence;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PROTECTED;
import static org.apache.commons.lang3.ObjectUtils.allNotNull;

@Embeddable
@ToString
@FieldNameConstants
@NoArgsConstructor(access = PROTECTED)
public class Periodo implements Comparable<Periodo> {

  @Column
  private LocalDate fim;
  @Column(nullable = false)
  private LocalDate inicio;

  public Periodo(LocalDate inicio) {
    this(inicio, null);
  }

  public Periodo(LocalDate inicio, LocalDate fim) {
    this.inicio = inicio;
    this.fim = fim;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int compareTo(Periodo that) {
    if (that == null) {
      return 1;
    }
    // data atual deve sempre vir primeiro.
    return new CompareToBuilder()
      .append(that.inicio, this.inicio)
      .append(that.fim, this.fim)
      .toComparison();
  }

  public boolean contem(LocalDate data) {
    return data != null && (!data.isBefore(inicio) && (fim == null || !data.isAfter(fim)));
  }

  public boolean periodoFechado() {
    return allNotNull(this.inicio, this.fim);
  }
}
