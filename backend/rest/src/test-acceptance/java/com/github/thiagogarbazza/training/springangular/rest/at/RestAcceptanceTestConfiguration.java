package com.github.thiagogarbazza.training.springangular.rest.at;

import com.github.thiagogarbazza.training.springangular.rest.RestConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({RestConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-rest-acceptance-test.properties")
class RestAcceptanceTestConfiguration {
}
