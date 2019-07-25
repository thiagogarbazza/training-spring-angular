package com.github.thiagogarbazza.training.springangular.rest.controler.grupodocumento.resource;

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
public class GrupoDocumentoParaSelecaoResource {

  private String codigo;
  private UUID id;
  private String nome;
}
