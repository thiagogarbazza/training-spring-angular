package com.github.thiagogarbazza.training.springangular.rest.configuration.throwable;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
class ThrowableResource {

  private String message;
  private String stackTrace;
  private Collection<SimpleMessage> violations;
}
