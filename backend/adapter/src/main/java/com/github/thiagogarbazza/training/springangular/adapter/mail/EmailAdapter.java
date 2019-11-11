package com.github.thiagogarbazza.training.springangular.adapter.mail;

import java.util.Collection;

public interface EmailAdapter {

  void enviar(Email email);

  void enviar(Collection<Email> emails);
}
