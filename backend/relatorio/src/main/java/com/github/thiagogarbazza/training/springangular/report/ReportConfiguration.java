package com.github.thiagogarbazza.training.springangular.report;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterConfiguration;
import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import({UtilConfiguration.class, AdapterConfiguration.class, CoreConfiguration.class})
@ComponentScan({ReportConfiguration.PACKAGE})
@PropertySource("classpath:application-report.properties")
public class ReportConfiguration {

  static final String PACKAGE = " com.github.thiagogarbazza.training.springangular.report";
}
