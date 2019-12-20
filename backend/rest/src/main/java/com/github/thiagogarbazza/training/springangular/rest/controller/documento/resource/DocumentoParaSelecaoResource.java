package com.github.thiagogarbazza.training.springangular.rest.controller.documento.resource;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Select;
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
public class DocumentoParaSelecaoResource implements Identifiable {

  private String codigo;
  private GrupoDocumentoVO4Select grupoDocumento;
  private UUID id;
  private String nome;
}
