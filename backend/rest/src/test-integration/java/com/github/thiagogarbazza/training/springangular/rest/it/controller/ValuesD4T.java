package com.github.thiagogarbazza.training.springangular.rest.it.controller;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@UtilityClass
public class ValuesD4T {

  public static final Boolean BOOLEAN = true;
  public static final Boolean[] BOOLEAN_ARRAY = {true, false};

  public static final LocalDate LOCAL_DATE = LocalDate.of(2019, 12, 31);
  public static final LocalDate[] LOCAL_DATE_ARRAY = {
    LocalDate.of(2019, 1, 1), LocalDate.of(2019, 1, 31), LocalDate.of(2019, 12, 1), LocalDate.of(2019, 12, 31)
  };

  public static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2019, 12, 31, 23, 59, 59);
  public static final LocalDateTime[] LOCAL_DATE_TIME_ARRAY = {
    LocalDateTime.of(2019, 1, 1, 23, 59, 59), LocalDateTime.of(2019, 1, 31, 0, 0, 1), LocalDateTime.of(2019, 12, 1, 0, 1, 2),
    LocalDateTime.of(2019, 12, 31, 1, 2, 3)
  };

  public static final BigDecimal NUMBER_BIG_DECIMAL = new BigDecimal("3.14");
  public static final BigDecimal[] NUMBER_BIG_DECIMAL_ARRAY = {new BigDecimal("3"), new BigDecimal("99.1"), new BigDecimal("987.001")};

  public static final Integer NUMBER_INTEGER = 7727;
  public static final Integer[] NUMBER_INTEGER_ARRAY = {7741, 7753, 7757};

  public static final String TEXT = "Algum texto simples com acentuação.";
  public static final String TEXT_2 = "INICIO !\"#$%'()*+,-./0123456789:;=>? @ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_ `abcdefghijklmnopqrstuvwxyz{|}~¡ "
    + "¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâ ãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ FIM";
  public static final String[] TEXT_ARRAY = {"AA", "AB", "AC", "Aa", "Ab", "Ac", "aa", "ab", "ac"};
}
