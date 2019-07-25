package com.github.thiagogarbazza.training.springangular.core.documentoprocessado;

import com.github.thiagogarbazza.training.springangular.util.persistence.consulta.AbstractFiltroPaginado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class DocumentoProcessadoFiltroConsulta extends AbstractFiltroPaginado {

  private Collection<UUID> clientes;
  private Collection<UUID> documentos;
  private Collection<Long> protocolos;
  private Collection<SituacaoDocumentoProcessado> situacoes;
}
