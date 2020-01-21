package com.github.thiagogarbazza.training.springangular.utiltest.stub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResetStubService {

  @Autowired
  private Collection<ResetStub> resetStubs;

  public void reset() {
    resetStubs.forEach(ResetStub::reset);
  }
}
