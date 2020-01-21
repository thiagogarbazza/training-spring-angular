package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@With
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(force = true, access = PRIVATE)
public class GrupoDocumentoVO4Update implements Identifiable {

  private String codigo;
  private UUID id;
  private String nome;
}
