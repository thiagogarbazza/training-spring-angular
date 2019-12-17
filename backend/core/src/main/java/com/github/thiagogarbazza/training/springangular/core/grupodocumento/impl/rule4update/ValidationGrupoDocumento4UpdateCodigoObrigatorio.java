package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.rule4update;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import com.github.thiagogarbazza.violationbuilder.ViolationBuilder;
import com.github.thiagogarbazza.violationbuilder.runner.ValidationRuleCumulative;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@Order(1)
@ValidationGrupoDocumento4Update
class ValidationGrupoDocumento4UpdateCodigoObrigatorio implements ValidationRuleCumulative<GrupoDocumentoVO4Update> {

  @Override
  public void run(final ViolationBuilder violationBuilder, final GrupoDocumentoVO4Update grupoDocumentoVO4Update) {
    violationBuilder.error(isBlank(grupoDocumentoVO4Update.getCodigo()),
      "grupo-documento.codigo-obrigatorio",
      "O campo 'código' deve ser preenchido.");
  }
}
