package com.github.thiagogarbazza.training.springangular.rest;

import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@Import({RestConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-rest-local.properties")
class RestExecucaoLocalConfiguration {
}
