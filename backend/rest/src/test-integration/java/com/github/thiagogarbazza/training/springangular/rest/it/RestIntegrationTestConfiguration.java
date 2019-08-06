package com.github.thiagogarbazza.training.springangular.rest.it;

import com.github.thiagogarbazza.training.springangular.rest.RestConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@Import({RestConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-rest-integration-test.properties")
class RestIntegrationTestConfiguration {
}
