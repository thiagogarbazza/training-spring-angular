package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.thiagogarbazza.training.springangular.util.ambiente.AmbienteExecucao;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OutputConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer customJson() {
    return builder -> {
      // human readable
      builder.indentOutput(AmbienteExecucao.DESCONHECIDO.equals(AmbienteExecucao.getInstance()));
      builder.modules(customModule());
      // exclude null values
      // builder.serializationInclusion(JsonInclude.Include.NON_NULL);
      // all lowercase with under score between words
      //builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
    };
  }

  private SimpleModule customModule() {
    SimpleModule module = new SimpleModule();

    module.addSerializer(new EnumIdentifiableWithNomeSerializer());
    module.addDeserializer(EnumIdentifiableWithNome.class, new EnumIdentifiableWithNomeDeserializer());

    return module;
  }
}
