package com.github.thiagogarbazza.training.springangular.geraresperado;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@SpringBootTest
//@TestConfiguration
@EnableAutoConfiguration
public @interface BatchGerarEsperadoMainAcceptanceTestRunner {
}
