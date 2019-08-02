package com.github.thiagogarbazza.training.springangular.util.at;

import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({UtilConfiguration.class})
@PropertySource("classpath:application-util-acceptance-test.properties")
class UtilAcceptanceTestConfiguration {
}
