package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractSearchFilter;
import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;

@Getter
@SuperBuilder
@ToString(callSuper = true)
public class GrupoDocumentoSearchFilter extends AbstractSearchFilter<GrupoDocumentoSortableColumns> {

  private final String codigo;
  private final Collection<SituacaoGrupoDocumento> situacoes;

  @Override
  protected Collection<OrderSpecifier> defaultOrdering() {
    return Arrays.asList(grupoDocumento.codigo.asc(), grupoDocumento.nome.asc());
  }
}
