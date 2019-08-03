package com.github.thiagogarbazza.training.springangular.rest.it.controler;

import com.github.thiagogarbazza.training.springangular.rest.it.RestIntegrationTestRunner;
import org.springframework.beans.factory.annotation.Value;

@RestIntegrationTestRunner
public class AppInfoIntegrationTest {

  @Value("${app.build-info.timestamp}")
  private String buildInfoTimestamp;
  @Value("${app.build-info.version}")
  private String buildInfoVersion;
}
