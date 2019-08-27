package com.github.thiagogarbazza.training.springangular.core.cliente.impl;

import com.github.thiagogarbazza.training.springangular.core.cliente.CLienteNovoVO;
import com.github.thiagogarbazza.training.springangular.core.cliente.impl.rulecriar.ValidationCLienteNovo;
import com.github.thiagogarbazza.violationbuilder.runner.ValidationRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.thiagogarbazza.violationbuilder.runner.RulesExecutor.rulesExecutor;

@Component
class ClienteValidador {

  @Autowired
  @ValidationCLienteNovo
  private List<ValidationRule<CLienteNovoVO>> regrasParaCriar;

  void aoCriar(CLienteNovoVO cLienteNovoVO) {
    rulesExecutor(regrasParaCriar, cLienteNovoVO);
  }
}
