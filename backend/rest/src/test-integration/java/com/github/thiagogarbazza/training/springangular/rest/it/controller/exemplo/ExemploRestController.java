package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/end-point-exemplo")
class ExemploRestController {

  @Autowired
  private ExemploRestService exemploRestService;

  @RequestMapping(method = RequestMethod.GET, path = "/get")
  public ExemploDataVO get(final ExemploDataVO exemploDataVO) {
    return exemploRestService.get(exemploDataVO);
  }

  @RequestMapping(method = RequestMethod.POST, path = "/post")
  public ExemploDataVO post(@RequestBody final ExemploDataVO exemploDataVO) {
    return exemploRestService.post(exemploDataVO);
  }
}
