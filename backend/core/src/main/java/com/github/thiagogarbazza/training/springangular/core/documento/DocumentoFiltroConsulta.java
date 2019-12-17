package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractSearchFilter;
import com.querydsl.core.types.OrderSpecifier;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Arrays;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;

@Getter
@ToString
@SuperBuilder
public class DocumentoFiltroConsulta extends AbstractSearchFilter<DocumentoOrdenacaoCampo> {

  private final String codigo;
  private final Collection<SituacaoDocumento> situacoes;

  @Override
  protected Collection<OrderSpecifier> defaultOrdering() {
    return Arrays.asList(
      documento.grupoDocumento.codigo.asc(),
      documento.codigo.asc()
                        );
  }
}
