package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AuditEntity;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.With;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@With
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(force = true, access = PRIVATE)
public class GrupoDocumentoVO4Detail implements Identifiable<UUID> {

  private final String codigo;
  private final AuditEntity creation;
  private final LocalDate data;
  private final LocalDateTime dataHora;
  private final Collection<HistoricoSituacao> historicoSituacaos;
  private final UUID id;
  private final AuditEntity modification;
  private final String nome;
  private final SituacaoGrupoDocumento situacao;

  @With
  @Value
  @Builder
  @AllArgsConstructor(access = PRIVATE)
  @NoArgsConstructor(force = true, access = PRIVATE)
  public static class HistoricoSituacao implements Identifiable<UUID> {

    private AuditEntity creation;
    private UUID id;
    private String motivo;
    private SituacaoGrupoDocumento situacao;

    @QueryProjection
    public HistoricoSituacao(final UUID id, final SituacaoGrupoDocumento situacao, final String motivo, final AuditEntity creation) {
      this.id = id;
      this.situacao = situacao;
      this.motivo = motivo;
      this.creation = creation;
    }
  }
}
