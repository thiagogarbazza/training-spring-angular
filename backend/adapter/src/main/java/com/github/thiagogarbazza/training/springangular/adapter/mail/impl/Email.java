package com.github.thiagogarbazza.training.springangular.adapter.mail.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.util.lang.StringUtil.VIRGULA;
import static lombok.AccessLevel.PRIVATE;
import static org.apache.commons.lang3.StringUtils.join;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class Email {

  private String assunto;
  private Collection<String> comCopia;
  private Collection<String> comCopiaOculta;
  private boolean importante;
  private String mensagem;
  private Collection<String> para;
  private String remetente;

  @Override
  public String toString() {
    return new StringBuilder()
      .append("\n###########################################################################################\n")
      .append("De: ").append(remetente).append("\n")
      .append("Para: ").append(join(para, VIRGULA)).append("\n")
      .append("Com cópia: ").append(join(comCopia, VIRGULA)).append("\n")
      .append("Com cópia oculta: ").append(join(comCopia, VIRGULA)).append("\n")
      .append("Assunto: ").append(assunto).append("\n")
      .append("Mensagem: ").append(mensagem).append("\n")
      .append("###########################################################################################\n\n")
      .toString();
  }
}
