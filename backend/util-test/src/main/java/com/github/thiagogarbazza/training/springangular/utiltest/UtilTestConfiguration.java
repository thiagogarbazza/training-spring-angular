package com.github.thiagogarbazza.training.springangular.utiltest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"com.github.thiagogarbazza.training.springangular.utiltest"})
@PropertySource("classpath:application-commons-test.properties")
public class UtilTestConfiguration {
}
