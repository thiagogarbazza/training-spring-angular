package com.github.thiagogarbazza.training.springangular.util.it;

import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({UtilConfiguration.class})
@PropertySource("classpath:application-util-integration-test.properties")
class UtilIntegrationTestConfiguration {
}
