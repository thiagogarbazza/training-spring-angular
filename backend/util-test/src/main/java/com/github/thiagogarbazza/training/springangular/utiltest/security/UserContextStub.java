package com.github.thiagogarbazza.training.springangular.utiltest.security;

import com.github.thiagogarbazza.training.springangular.utiltest.stub.ResetStub;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class UserContextStub implements ResetStub {

  public void reset() {

  }
}
