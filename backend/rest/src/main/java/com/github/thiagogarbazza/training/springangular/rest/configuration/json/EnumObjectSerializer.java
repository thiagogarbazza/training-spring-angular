package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento;

import java.io.IOException;

public class EnumObjectSerializer extends JsonSerializer<SituacaoGrupoDocumento> {

  @Override
  public void serialize(final SituacaoGrupoDocumento value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    gen.writeObjectField("id", value.getId());
    gen.writeStringField("description", value.getDescription());
    gen.writeEndObject();
  }
}
