package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class GrupoDocumentoVO4Update implements Identifiable {

  private String codigo;
  private UUID id;
  private String nome;
}
