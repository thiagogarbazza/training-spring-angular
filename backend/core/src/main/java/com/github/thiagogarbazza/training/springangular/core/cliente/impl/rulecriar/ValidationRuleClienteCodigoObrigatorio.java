package com.github.thiagogarbazza.training.springangular.core.cliente.impl.rulecriar;

import com.github.thiagogarbazza.training.springangular.core.cliente.CLienteNovoVO;
import com.github.thiagogarbazza.violationbuilder.ViolationBuilder;
import com.github.thiagogarbazza.violationbuilder.runner.ValidationRuleCumulative;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@Order(1)
@ValidationCLienteNovo
class ValidationRuleClienteCodigoObrigatorio implements ValidationRuleCumulative<CLienteNovoVO> {

  @Override
  public void run(final ViolationBuilder violationBuilder, final CLienteNovoVO cLienteNovoVO) {
    violationBuilder.error(isBlank(cLienteNovoVO.getCodigo()), "cliente.codigo-obrigatorio", "O campo 'código' deve ser preenchido.");
  }
}
