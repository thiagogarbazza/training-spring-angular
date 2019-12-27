package com.github.thiagogarbazza.training.springangular.util.persistence.enumeration;

public interface EnumIdentifiableWithDescription<ID> extends EnumIdentifiable<ID> {

  String getDescription();
}
