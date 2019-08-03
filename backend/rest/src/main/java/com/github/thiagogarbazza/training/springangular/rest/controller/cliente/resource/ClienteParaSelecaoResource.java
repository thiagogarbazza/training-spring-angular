package com.github.thiagogarbazza.training.springangular.rest.controller.cliente.resource;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PUBLIC;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PUBLIC)
@AllArgsConstructor(access = PUBLIC)
public class ClienteParaSelecaoResource implements Identifiable {

  private String codigo;
  private UUID id;
  private String nome;
}
