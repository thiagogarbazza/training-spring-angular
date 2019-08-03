package com.github.thiagogarbazza.training.springangular.report.at;

import com.github.thiagogarbazza.training.springangular.report.ReportConfiguration;
import com.github.thiagogarbazza.training.springangular.utiltest.UtilTestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({ReportConfiguration.class, UtilTestConfiguration.class})
@PropertySource("classpath:application-report-acceptance-test.properties")
class ReportAcceptanceTestConfiguration {
}
