package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithNome;

import java.io.IOException;

class EnumIdentifiableWithNomeSerializer extends StdSerializer<EnumIdentifiableWithNome> {

  public EnumIdentifiableWithNomeSerializer() {
    super(EnumIdentifiableWithNome.class);
  }

  @Override
  public void serialize(final EnumIdentifiableWithNome value, final JsonGenerator generator, final SerializerProvider provider) throws IOException {
    generator.writeStartObject();
    generator.writeNumberField("id", value.getId());
    generator.writeStringField("nome", value.getNome());
    generator.writeStringField("enumName", ((Enum) value).name());
    generator.writeEndObject();
  }
}
