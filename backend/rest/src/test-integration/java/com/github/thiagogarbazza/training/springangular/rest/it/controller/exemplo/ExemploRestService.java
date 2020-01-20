package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
class ExemploRestService {

  ExemploDataVO get(final ExemploDataVO dataExemploVO) {
    return dataExemploVO;
  }

  ExemploDataVO post(final ExemploDataVO dataExemploVO) {
    return dataExemploVO;
  }
}
