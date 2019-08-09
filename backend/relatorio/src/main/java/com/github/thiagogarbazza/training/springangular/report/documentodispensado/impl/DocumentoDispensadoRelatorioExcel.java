package com.github.thiagogarbazza.training.springangular.report.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.AbstractRelatorioTabelaSimplesExcel;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.Coluna;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoUtil.periodoToString;
import static java.util.Arrays.asList;

class DocumentoDispensadoRelatorioExcel extends AbstractRelatorioTabelaSimplesExcel<DocumentoDispensado> {

  private final Collection<Coluna<DocumentoDispensado>> colunas;
  private final Collection<DocumentoDispensado> itens;

  public DocumentoDispensadoRelatorioExcel(Collection<DocumentoDispensado> itens) {
    super("documentos-dispensados");
    this.itens = itens;
    this.colunas = new ArrayList<>(asList(DocumentoDispensadoRelatorioExcelColuna.values()));
  }

  @Override
  protected Collection<Coluna<DocumentoDispensado>> colunas() {
    return colunas;
  }

  @Override
  protected Collection<DocumentoDispensado> itens() {
    return itens;
  }

  @Getter
  private enum DocumentoDispensadoRelatorioExcelColuna implements Coluna<DocumentoDispensado> {

    GRUPO_DOCUMENTO(0, 9250, "Grupo documento") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getDocumento().getGrupoDocumento().getNome();
      }
    },
    DOCUMENTO(1, 9250, "Documento") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getDocumento().getNome();
      }
    },
    CLIENTE(2, 9250, "Cliente") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getCliente().getNome();
      }
    },
    VIGENCIA(3, 9250, "Vigência") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return periodoToString(item.getVigencia());
      }
    },
    SITUACAO(4, 9250, "Situação") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getSituacao().getDescription();
      }
    };

    private int index;
    private int tamanho;
    private String titulo;

    DocumentoDispensadoRelatorioExcelColuna(int index, int tamanho, String titulo) {
      this.index = index;
      this.titulo = titulo;
      this.tamanho = tamanho;
    }
  }
}
