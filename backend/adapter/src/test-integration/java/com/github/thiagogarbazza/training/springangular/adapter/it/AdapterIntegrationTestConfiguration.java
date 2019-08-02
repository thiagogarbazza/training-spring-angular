package com.github.thiagogarbazza.training.springangular.adapter.it;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({AdapterConfiguration.class})
@PropertySource("classpath:application-adapter-integration-test.properties")
class AdapterIntegrationTestConfiguration {
}
