package com.github.thiagogarbazza.training.springangular.report.it;

import com.github.thiagogarbazza.training.springangular.report.ReportConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({ReportConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-report-integration-test.properties")
class ReportIntegrationTestConfiguration {
}
