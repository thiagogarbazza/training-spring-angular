package com.github.thiagogarbazza.training.springangular.adapter.mail.impl;

import com.github.thiagogarbazza.training.springangular.adapter.mail.Email;
import com.github.thiagogarbazza.training.springangular.adapter.mail.EmailAdapter;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class EmailAdapterImpl implements EmailAdapter {

  @Override
  public void enviar(final Email email) {
    throw new NotImplementedException("Não implementado.");
  }

  @Override
  public void enviar(final Collection<Email> emails) {
    throw new NotImplementedException("Não implementado.");
  }
}
