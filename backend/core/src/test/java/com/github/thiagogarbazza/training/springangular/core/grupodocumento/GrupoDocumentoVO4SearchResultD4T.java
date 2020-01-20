package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.security.Action;
import com.github.thiagogarbazza.training.springangular.util.security.Actions;
import lombok.experimental.UtilityClass;

import java.util.UUID;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.SituacaoGrupoDocumento.ATIVO;

@UtilityClass
public class GrupoDocumentoVO4SearchResultD4T {

  public static GrupoDocumentoVO4SearchResult grupoDocumentoVO4SearchResultQualquer() {
    final Actions actions = new Actions();
    actions.put(Actions.ACTION_CAN_DETAIL, Action.builder()
      .doAction(true)
      .description("Detalhar")
      .tooltip("Clique aqui para detalhar este registro.")
      .build());
    actions.put(Actions.ACTION_CAN_DELETE, Action.builder()
      .doAction(false)
      .description("Deletar")
      .tooltip("Clique aqui para deletar este registro.")
      .build());

    return GrupoDocumentoVO4SearchResult.builder()
      .id(UUID.fromString("df160f6e-e4e5-4fbf-a39f-d92acff9eade"))
      .codigo("GRP-CODIGO")
      .nome("GRP-NOME")
      .situacao(ATIVO)
      .actions(actions)
      .build();
  }
}
