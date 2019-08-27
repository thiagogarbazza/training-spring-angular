package com.github.thiagogarbazza.training.springangular.core.cliente;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@RequiredArgsConstructor(access = PRIVATE)
public class CLienteNovoVO {

  private final String codigo;
  private final String nome;
}
