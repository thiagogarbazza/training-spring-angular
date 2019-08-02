package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.core.cliente.Cliente;
import com.github.thiagogarbazza.training.springangular.core.documento.Documento;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@AllArgsConstructor(access = PRIVATE)
class DadosGeracaoEsperado {

  private Collection<Cliente> clientes;
  private LocalDate dataReferencia;
  private Documento documento;
  private Collection<DocumentoDispensado> documentoDispensados;
}
