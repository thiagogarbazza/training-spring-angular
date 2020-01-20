package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.ValuesD4T;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiable;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(force = true, access = PRIVATE)
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
  private String text2;
  private Collection<String> texts;

  static ExemploDataVO getExemploDataVO() {
    return builder()
      .condition(ValuesD4T.BOOLEAN)
      .conditions(Arrays.asList(ValuesD4T.BOOLEAN_ARRAY))
      .localDate(ValuesD4T.LOCAL_DATE)
      .localDates(Arrays.asList(ValuesD4T.LOCAL_DATE_ARRAY))
      .localDateTime(ValuesD4T.LOCAL_DATE_TIME)
      .localDateTimes(Arrays.asList(ValuesD4T.LOCAL_DATE_TIME_ARRAY))
      .numberBigDecimal(ValuesD4T.NUMBER_BIG_DECIMAL)
      .numberBigDecimals(Arrays.asList(ValuesD4T.NUMBER_BIG_DECIMAL_ARRAY))
      .numberInteger(ValuesD4T.NUMBER_INTEGER)
      .numberIntegers(Arrays.asList(ValuesD4T.NUMBER_INTEGER_ARRAY))
      .text(ValuesD4T.TEXT)
      .text2(ValuesD4T.TEXT_2)
      .texts(Arrays.asList(ValuesD4T.TEXT_ARRAY))
      .build();
  }

  @Getter
  @JsonFormat(shape = JsonFormat.Shape.OBJECT)
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
  @JsonFormat(shape = JsonFormat.Shape.OBJECT)
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
