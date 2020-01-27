package com.github.thiagogarbazza.training.springangular.core.grupodocumento;

import com.github.thiagogarbazza.training.springangular.util.persistence.entity.AuditEntity;
import com.github.thiagogarbazza.training.springangular.util.persistence.entity.Identifiable;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE)
public class GrupoDocumentoVO4Detail implements Identifiable<UUID> {

  private final LocalDate data = LocalDate.of(2020, 01, 31);
  private final LocalDateTime dataHora = LocalDateTime.of(2020, 1, 31, 23, 59, 59, 999);
  private String codigo;
  private AuditEntity creation;
  private Collection<HistoricoSituacao> historicoSituacaos;
  private UUID id;
  private AuditEntity modification;
  private String nome;
  private SituacaoGrupoDocumento situacao;

  @Getter
  @Builder
  @ToString
  @NoArgsConstructor(access = PRIVATE)
  @AllArgsConstructor(access = PRIVATE)
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
