package com.github.thiagogarbazza.training.springangular.rest.it;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RestIntegrationTestConfiguration.class)
public @interface RestIntegrationTestRunner {
}
