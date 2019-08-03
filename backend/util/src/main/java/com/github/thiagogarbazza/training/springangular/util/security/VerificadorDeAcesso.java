package com.github.thiagogarbazza.training.springangular.util.security;

public interface VerificadorDeAcesso {

  boolean temRole(Role... roles);
}
