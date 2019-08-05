package com.github.thiagogarbazza.training.springangular.geraresperado.it;

import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({CoreConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-gerar-esperado-integration-test.properties")
class GerarEsperadoIntegrationTestConfiguration {
}
