package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import static com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao.getAmbienteExecucao;

@Configuration
class JacksonConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    return new Jackson2ObjectMapperBuilder()
      .indentOutput(AmbienteExecucao.DESCONHECIDO.equals(getAmbienteExecucao()))
      .simpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
      .modules(customModule())
      .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .featuresToEnable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
      .featuresToEnable(MapperFeature.ALLOW_COERCION_OF_SCALARS)

      .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
      .featuresToEnable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)

      .featuresToEnable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
      .featuresToDisable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
      ;
  }

  private SimpleModule customModule() {
    return new SimpleModule()
      .addSerializer(new EnumIdentifiableWithDescriptionSerializer());
  }
}
