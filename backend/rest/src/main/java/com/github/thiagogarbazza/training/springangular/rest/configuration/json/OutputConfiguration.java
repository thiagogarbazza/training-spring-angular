package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
class OutputConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilder customJson() {
    return new Jackson2ObjectMapperBuilder()
      .indentOutput(AmbienteExecucao.DESCONHECIDO.equals(AmbienteExecucao.getInstance()))
      .modules(customModule())
      .serializationInclusion(JsonInclude.Include.NON_NULL)
      .propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
  }

  private SimpleModule customModule() {
    SimpleModule module = new SimpleModule();

    module.addSerializer(new EnumIdentifiableWithDescriptionSerializer());

    return module;
  }
}
