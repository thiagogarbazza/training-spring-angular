package com.github.thiagogarbazza.training.springangular.rest.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.thiagogarbazza.training.springangular.rest.configuration.json.Jackson2ObjectMapperBuilderCuston;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
class WebMvcConfigurerCustom implements WebMvcConfigurer {

/*  @Override
  public void configureContentNegotiation(final ContentNegotiationConfigurer contentNegotiationConfigurer) {
    contentNegotiationConfigurer
      .favorPathExtension(false)
      .favorParameter(true)
      .ignoreAcceptHeader(true)
      .parameterName("mediaType")
      .defaultContentType(MediaType.APPLICATION_JSON)
      .mediaType("xml", MediaType.APPLICATION_XML)
      .mediaType("json", MediaType.APPLICATION_JSON);
  }*/

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder();

    final ObjectMapper objectMapper = jackson2ObjectMapperBuilder.build();
    converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
  }
}
