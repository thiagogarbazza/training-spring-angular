package com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Create;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoVO4Update;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.rule4create.ValidationGrupoDocumento4Create;
import com.github.thiagogarbazza.training.springangular.core.grupodocumento.impl.rule4update.ValidationGrupoDocumento4Update;
import com.github.thiagogarbazza.violationbuilder.runner.ValidationRule;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.github.thiagogarbazza.violationbuilder.runner.RulesExecutor.rulesExecutor;

@Component
@CommonsLog
class GrupoDocumentoValidation {

  @Autowired
  @ValidationGrupoDocumento4Create
  private List<ValidationRule<GrupoDocumentoVO4Create>> rules4Create;
  @Autowired
  @ValidationGrupoDocumento4Update
  private List<ValidationRule<GrupoDocumentoVO4Update>> rules4Update;

  void onCreate(GrupoDocumentoVO4Create grupoDocumentoVO4Create) {
    rulesExecutor(this.rules4Create, grupoDocumentoVO4Create);
  }

  void onUpdate(GrupoDocumentoVO4Update grupoDocumentoVO4Update) {
    rulesExecutor(this.rules4Update, grupoDocumentoVO4Update);
  }
}
