package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class Ordering<T extends OrderableColumn> {

  private T column;
  private OrderableDirection direction;
  private int index;
}
