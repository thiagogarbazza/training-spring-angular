package com.github.thiagogarbazza.training.springangular.core.at;

import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({CoreConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-core-acceptance-test.properties")
class CoreAcceptanceTestConfiguration {
}
