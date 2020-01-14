package com.github.thiagogarbazza.training.springangular.rest.it.objectmapper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO;

import java.io.IOException;

public class EnumObjectSerializer extends JsonSerializer<ExemploDataVO.ExampleEnumObject> {

  @Override
  public void serialize(final ExemploDataVO.ExampleEnumObject value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {

  }
}
