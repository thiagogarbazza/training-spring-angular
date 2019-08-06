package com.github.thiagogarbazza.training.springangular.rest;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterConfiguration;
import com.github.thiagogarbazza.training.springangular.core.CoreConfiguration;
import com.github.thiagogarbazza.training.springangular.report.ReportConfiguration;
import com.github.thiagogarbazza.training.springangular.util.UtilConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.Formatter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@EnableWebMvc
@Configuration
@Import({UtilConfiguration.class, AdapterConfiguration.class, CoreConfiguration.class, ReportConfiguration.class})
@ComponentScan({RestConfiguration.PACOTE})
@PropertySource("classpath:application-rest.properties")
public class RestConfiguration {

  static final String PACOTE = "com.github.thiagogarbazza.training.springangular.rest";

  @Bean
  public Formatter<LocalDate> localDateFormatter() {
    return new Formatter<LocalDate>() {
      @Override
      public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
      }

      @Override
      public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ISO_DATE.format(object);
      }
    };
  }
}
