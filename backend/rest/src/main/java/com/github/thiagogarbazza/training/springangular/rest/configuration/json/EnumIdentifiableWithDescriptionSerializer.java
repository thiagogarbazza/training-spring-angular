package com.github.thiagogarbazza.training.springangular.rest.configuration.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.github.thiagogarbazza.training.springangular.util.persistence.enumeration.EnumIdentifiableWithDescription;

import java.io.IOException;

class EnumIdentifiableWithDescriptionSerializer extends StdSerializer<EnumIdentifiableWithDescription> {

  public EnumIdentifiableWithDescriptionSerializer() {
    super(EnumIdentifiableWithDescription.class);
  }

  @Override
  public void serialize(final EnumIdentifiableWithDescription value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {
    gen.writeStartObject();
    gen.writeNumberField("id", value.getId());
    gen.writeStringField("description", value.getDescription());
    gen.writeEndObject();
  }
}
