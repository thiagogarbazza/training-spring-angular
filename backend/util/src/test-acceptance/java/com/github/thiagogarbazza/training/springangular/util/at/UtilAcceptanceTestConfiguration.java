package com.github.thiagogarbazza.training.springangular.util.at;

import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories({"com.github.thiagogarbazza.training.springangular.util.it"})
@Import({UtilConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-util-acceptance-test.properties")
class UtilAcceptanceTestConfiguration {
}
