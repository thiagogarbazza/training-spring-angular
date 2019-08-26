package com.github.thiagogarbazza.training.springangular.adapter.mail;

import com.github.thiagogarbazza.training.springangular.adapter.AdapterException;
import lombok.Getter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Primary
@Service
@CommonsLog
public class EmailAdapterStub implements EmailAdapter {

  @Getter
  private final Collection<Email> emails = new ArrayList<>();
  private final Collection<String> remetentesFalha = new ArrayList<>();

  @Override
  public void enviar(final Email email) {
    if (email.getAssunto().contains("Com erro")) {
      throw new AdapterException("Erro ao enviar e-mail, erro forçado.", new Throwable());
    }

    log.trace(email);
  }

  @Override
  public void enviar(final Collection<Email> emails) {
    for (final Email email : emails) {
      enviar(email);
    }
  }

  public void clean() {
    emails.clear();
    remetentesFalha.clear();
  }
}
