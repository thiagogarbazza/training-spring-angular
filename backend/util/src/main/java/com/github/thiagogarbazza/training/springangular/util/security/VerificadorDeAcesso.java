package com.github.thiagogarbazza.training.springangular.util.security;

public interface VerificadorDeAcesso {

  boolean naoTemRole(Role... roles);

  boolean temRole(Role... roles);
}
