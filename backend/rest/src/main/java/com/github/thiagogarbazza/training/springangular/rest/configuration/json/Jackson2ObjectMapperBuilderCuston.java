package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.experimental.UtilityClass;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@UtilityClass
public class Jackson2ObjectMapperBuilderCuston {

  public static Jackson2ObjectMapperBuilder newJacksonBuilder() {
    return new Jackson2ObjectMapperBuilder()
      .indentOutput(false)
      .simpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
      .modules(customModule())
      .modules(new JavaTimeModule())
      .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .featuresToEnable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
      .featuresToEnable(MapperFeature.ALLOW_COERCION_OF_SCALARS)

      .featuresToEnable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
      .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)

      .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
      .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      ;
  }

  private static SimpleModule customModule() {
    return new SimpleModule()
      //.addSerializer(new EnumIdentifiableSerializer())
      //.addSerializer(new EnumIdentifiableWithDescriptionSerializer())
      ;
  }
}
