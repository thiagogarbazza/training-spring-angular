package com.github.thiagogarbazza.training.springangular.adapter.mail;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.adapter.mail.EmailPriority.NORMAL;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@RequiredArgsConstructor(access = PRIVATE)
public class Email {

  private final String assunto;
  private final Collection<String> destinatario;
  private final Collection<String> destinatarioEmCopia;
  private final Collection<String> destinatarioEmCopiaOculta;
  private final String mensagem;
  @Builder.Default
  private final EmailPriority prioridade = NORMAL;
  private final String remetente;
}
