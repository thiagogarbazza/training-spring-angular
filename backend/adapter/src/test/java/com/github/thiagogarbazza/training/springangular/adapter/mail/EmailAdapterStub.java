package com.github.thiagogarbazza.training.springangular.adapter.mail;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterException;
import com.google.common.collect.ImmutableSet;
import lombok.Getter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.adapter.mail.EmailD4T.emailToString;
import static java.text.MessageFormat.format;
import static org.apache.commons.collections4.CollectionUtils.containsAny;

@Primary
@Service
@CommonsLog
public class EmailAdapterStub implements EmailAdapter {

  private static final Collection<String> DESTINATARIOS_FALHAM = ImmutableSet.of("remetente-falha@gmail.com");
  private static final Collection<String> REMETENTES_FALHAM = ImmutableSet.of("destinatario-falha@gmail.com");

  @Getter
  private final Collection<Email> emails = new ArrayList<>();

  @Override
  public void enviar(final Email email) {
    if (REMETENTES_FALHAM.contains(email.getRemetente())
      || containsAny(DESTINATARIOS_FALHAM, email.getDestinatario())
      || email.getAssunto().contains("Com erro")) {
      throw new AdapterException(format("STUB: Erro ao enviar e-mail. E-mails que geram falha no Remetente ''{0}'' ou nos destinatários ''{0}''!",
        REMETENTES_FALHAM, DESTINATARIOS_FALHAM));
    }

    log.trace(emailToString(email));
  }

  @Override
  public void enviar(final Collection<Email> emails) {
    for (final Email email : emails) {
      enviar(email);
    }
  }

  public void clean() {
    emails.clear();
  }
}
