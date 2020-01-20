package com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.thiagogarbazza.training.springangular.rest.it.controller.exemplo.ExemploDataVO.getExemploDataVO;

@RestController
@RequestMapping("/end-point-exemplo")
class ExemploRestController {

  @Autowired
  private ExemploRestService exemploRestService;

  @GetMapping("/get")
  public ExemploDataVO get(final ExemploDataVO exemploDataVO) {
    return exemploRestService.get(exemploDataVO);
  }

  @PostMapping("/post")
  public ExemploDataVO post(@RequestBody final ExemploDataVO exemploDataVO) {
    return exemploRestService.post(exemploDataVO);
  }

  @GetMapping
  public ExemploDataVO root() {
    return getExemploDataVO();
  }
}
