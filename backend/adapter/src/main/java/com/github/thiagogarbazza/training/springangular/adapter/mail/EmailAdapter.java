package com.github.thiagogarbazza.training.springangular.adapter.mail;

import java.util.Collection;

public interface EmailAdapter {

  void enviar(final Email email);

  void enviar(final Collection<Email> emails);
}
