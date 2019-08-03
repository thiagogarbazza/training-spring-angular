package com.github.thiagogarbazza.training.springangular.report.it;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ReportIntegrationTestConfiguration.class)
public @interface ReportIntegrationTestRunner {
}
