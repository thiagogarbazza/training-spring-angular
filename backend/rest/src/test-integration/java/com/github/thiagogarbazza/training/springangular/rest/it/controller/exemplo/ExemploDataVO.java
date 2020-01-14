package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiable;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class ExemploDataVO {

  private Boolean condition;
  private Collection<Boolean> conditions;
  private LocalDate localDate;
  private LocalDateTime localDateTime;
  private Collection<LocalDateTime> localDateTimes;
  private Collection<LocalDate> localDates;
  private BigDecimal numberBigDecimal;
  private Collection<BigDecimal> numberBigDecimals;
  private Integer numberInteger;
  private Collection<Integer> numberIntegers;
  private String text;
  private Collection<String> texts;

  static ExemploDataVO getExemploDataVO() {
    return builder()
      .condition(TRUE)
      .conditions(Arrays.asList(TRUE, FALSE))
      .localDate(LocalDate.of(2019, 12, 31))
      .localDates(Arrays.asList(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 31), LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31)))
      .localDateTime(LocalDateTime.of(2019, 12, 31, 23, 59, 59))
      .localDateTimes(
        Arrays.asList(LocalDateTime.of(2019, 1, 1, 0, 0, 1), LocalDateTime.of(2019, 1, 31, 23, 59, 59), LocalDateTime.of(2019, 12, 1, 0, 1, 2),
          LocalDateTime.of(2019, 12, 31, 23, 59, 59)))
      .numberBigDecimal(new BigDecimal("3.14"))
      .numberBigDecimals(Arrays.asList(new BigDecimal("3"), new BigDecimal("4.1"), new BigDecimal("11.001")))
      .numberInteger(Integer.valueOf("7727"))
      .numberIntegers(Arrays.asList(Integer.valueOf("7741"), Integer.valueOf("7753"), Integer.valueOf("7757")))
      .text("Algum texto grande para exemplo e com acentuação")
      .texts(Arrays.asList("AA", "AB", "AC", "Aa", "Ab", "Ac", "aa", "ab", "ac"))
      .build();
  }

  @Getter
  public enum ExampleEnumIdentifiable implements EnumIdentifiable<Integer> {
    VALOR_01(1, "Valor 01"),
    VALOR_02(2, "Valor 02"),
    VALOR_03(3, "Valor 03");

    private final String description;
    private final Integer id;

    ExampleEnumIdentifiable(final Integer id, final String description) {
      this.id = id;
      this.description = description;
    }
  }

  @Getter
  public enum ExampleEnumIdentifiableWithDescription implements EnumIdentifiableWithDescription<Integer> {
    VALOR_01(1, "Valor 01"),
    VALOR_02(2, "Valor 02"),
    VALOR_03(3, "Valor 03");

    private final String description;
    private final Integer id;

    ExampleEnumIdentifiableWithDescription(final Integer id, final String description) {
      this.id = id;
      this.description = description;
    }
  }

  @Getter
  public enum ExampleEnumObject {
    VALOR_01(1, "Valor 01"),
    VALOR_02(2, "Valor 02"),
    VALOR_03(3, "Valor 03");

    private final int code;
    private final String description;

    ExampleEnumObject(final int code, final String description) {
      this.code = code;
      this.description = description;
    }
  }

  public enum ExampleEnumSimples {
    VALOR_01,
    VALOR_02,
    VALOR_03;
  }
}
