package com.github.thiagogarbazza.training.springangular.core.it;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

@Target(TYPE)
@Retention(RUNTIME)
@ExtendWith(SpringExtension.class)
@Transactional(propagation = REQUIRED, readOnly = true)
@ContextConfiguration(classes = CoreIntegrationTestConfiguration.class)
public @interface CoreIntegrationTestRunner {
}
