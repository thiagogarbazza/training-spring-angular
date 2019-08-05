package com.github.thiagogarbazza.training.springangular.geraresperado.at;

import com.github.thiagogarbazza.training.springangular.geraresperado.configuration.BatchGerarEsperadoConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({BatchGerarEsperadoConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-gerar-esperado-acceptance-test.properties")
class GerarEsperadoAcceptanceTestConfiguration {
}
