package com.github.thiagogarbazza.training.springangular.adapter.mail;

import lombok.experimental.UtilityClass;

import static com.github.thiagogarbazza.training.springangular.adapter.mail.EmailPriority.LOWEST;
import static com.github.thiagogarbazza.training.springangular.util.lang.StringUtil.VIRGULA;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.StringUtils.LF;
import static org.apache.commons.lang3.StringUtils.join;

@UtilityClass
class EmailD4T {

  public static Email buildEmailQualquer() {
    return Email.builder()
      .prioridade(LOWEST)
      .remetente("remetente@gmail.com")
      .destinatario(singletonList("destinatario@gmail.com"))
      .destinatarioEmCopia(singletonList("destinatario-em-copia@gmail.com"))
      .destinatarioEmCopiaOculta(singletonList("destinatario-em-copia-oculta@gmail.com"))
      .assunto("Assunto do e-mail")
      .mensagem("Conteúdo do e-mail")
      .build();
  }

  public static String emailToString(Email email) {
    return LF
      + "###########################################################################################" + LF
      + "## Prioridade: " + email.getPrioridade() + LF
      + "## Remetente: " + email.getRemetente() + LF
      + "## Destinatário: " + join(email.getDestinatario(), VIRGULA) + LF
      + "## Destinatário em cópia: " + join(email.getDestinatarioEmCopia(), VIRGULA) + LF
      + "## Destinatário em cópia oculta: " + join(email.getDestinatarioEmCopiaOculta(), VIRGULA) + LF
      + "## Assunto: " + email.getAssunto() + LF
      + "## Mensagem: " + email.getMensagem() + LF
      + "###########################################################################################";
  }
}
