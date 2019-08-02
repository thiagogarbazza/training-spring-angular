package com.github.thiagogarbazza.training.springangular.adapter;

import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({UtilConfiguration.class})
@ComponentScan({AdapterConfiguration.PACKAGE})
@PropertySource("classpath:application-adapter.properties")
public class AdapterConfiguration {

  static final String PACKAGE = " com.github.thiagogarbazza.training.springangular.adapter";
}
