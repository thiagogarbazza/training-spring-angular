package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.rule4create;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.violationbuilder.ViolationBuilder;
import com.github.thiagogarbazza.violationbuilder.runner.ValidationRuleCumulative;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@Order(2)
@ValidationGrupoDocumento4Create
class ValidationGrupoDocumento4CreateNomeObrigatorio implements ValidationRuleCumulative<GrupoDocumentoVO4Create> {

  @Override
  public void run(final ViolationBuilder violationBuilder, final GrupoDocumentoVO4Create grupoDocumentoVO4Create) {
    violationBuilder.error(isBlank(grupoDocumentoVO4Create.getNome()),
      "grupo-documento.nome-obrigatorio",
      "O campo 'nome' deve ser preenchido.");
  }
}
