package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractSearchFilter;
import com.google.common.collect.ImmutableList;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.grupodocumento.QGrupoDocumento.grupoDocumento;
import static com.github.thiagogarbazza.training.springangular.util.persistence.consulta.PredicateUtil.equalsIfNotNull;
import static com.github.thiagogarbazza.training.springangular.util.persistence.consulta.PredicateUtil.inIfNotNull;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor(access = PRIVATE)
public class GrupoDocumentoSearchFilter extends AbstractSearchFilter<GrupoDocumentoSortableColumns> {

  private String codigo;
  private Collection<SituacaoGrupoDocumento> situacoes;

  @Override
  protected Collection<OrderSpecifier> defaultOrdering() {
    return ImmutableList.<OrderSpecifier>builder()
      .add(grupoDocumento.codigo.asc())
      .add(grupoDocumento.nome.asc())
      .build();
  }

  public Predicate predicate() {
    return new BooleanBuilder()
      .and(equalsIfNotNull(grupoDocumento.codigo, this.codigo))
      .and(inIfNotNull(grupoDocumento.situacao, this.situacoes))
      .getValue();
  }
}
