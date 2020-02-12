package com.github.thiagogarbazza.training.springangular.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class WebMvcConfigurerCustom implements WebMvcConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
    registrar.setUseIsoFormat(true);
    registrar.registerFormatters(registry);
  }

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

//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//    final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder = Jackson2ObjectMapperBuilderCuston.newJacksonBuilder();
//
//    final ObjectMapper objectMapper = jackson2ObjectMapperBuilder.build();
//    converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
//  }
}
