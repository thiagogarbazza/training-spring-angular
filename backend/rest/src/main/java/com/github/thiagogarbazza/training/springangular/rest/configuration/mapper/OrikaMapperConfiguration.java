package com.github.thiagogarbazza.training.springangular.rest.configuration.mapper;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class OrikaMapperConfiguration extends ConfigurableMapper implements ApplicationContextAware {

  private ApplicationContext applicationContext;

  public OrikaMapperConfiguration() {
    super(false);
  }

  @Override
  public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
    super.init();
  }

  @Override
  protected void configure(MapperFactory factory) {
    configurarAssemblers(factory);
    registrarConversores(factory);
    // registrarMapeadores(factory);
  }

  private void configurarAssemblers(MapperFactory factory) {
    final Map<String, AssemblerMapper> assemblers = applicationContext.getBeansOfType(AssemblerMapper.class);
    for (final AssemblerMapper assembler : assemblers.values()) {
      assembler.configure(factory);
    }
  }

  private void registrarConversores(MapperFactory factory) {
    final Map<String, Converter> conversoresBidirecionais = applicationContext.getBeansOfType(Converter.class);
    for (final Converter conversor : conversoresBidirecionais.values()) {
      factory.getConverterFactory().registerConverter(conversor);
    }
  }

  private void registrarMapeadores(MapperFactory factory) {
    final Map<String, Mapper> mapeadores = applicationContext.getBeansOfType(Mapper.class);
    for (final Mapper mapeador : mapeadores.values()) {
      factory.classMap(mapeador.getAType(), mapeador.getBType())
        .byDefault()
        .customize((Mapper) mapeador)
        .register();
    }
  }
}
