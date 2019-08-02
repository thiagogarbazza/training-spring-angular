package com.github.thiagogarbazza.training.springangular.core.documento;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractFiltroPaginado;
import com.querydsl.core.types.OrderSpecifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.core.documento.QDocumento.documento;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DocumentoFiltroConsulta extends AbstractFiltroPaginado {

  private String codigo;
  private Collection<SituacaoDocumento> situacoes;

  @Override
  protected Collection<OrderSpecifier> orderByDefault() {
    return Arrays.asList(
      documento.grupoDocumento.codigo.asc(),
      documento.codigo.asc()
                        );
  }
}
