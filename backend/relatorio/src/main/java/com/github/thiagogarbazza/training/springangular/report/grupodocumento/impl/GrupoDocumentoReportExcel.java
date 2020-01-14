package com.github.thiagogarbazza.training.springangular.report.grupodocumento.impl;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumento;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.AbstractRelatorioExcel;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.Coluna;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelTableBuilder;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Collection;

import static java.util.Arrays.asList;

class GrupoDocumentoReportExcel extends AbstractRelatorioExcel {

  private final Collection<GrupoDocumento> itens;

  GrupoDocumentoReportExcel(Collection<GrupoDocumento> itens) {
    super("grupo-documento");
    this.itens = itens;
  }

  @Override
  protected void buildSheets() {
    final Sheet sheet = newSheet("grupo-documento");

    ExcelTableBuilder.<GrupoDocumento>builder()
      .sheet(sheet)
      .rowStart(0)
      .colStart(0)
      .title("Grupo documento")
      .colunas(asList(GrupoDocumentoReportExcelColuna.values()))
      .items(this.itens)
      .build();
  }

  @Getter
  private enum GrupoDocumentoReportExcelColuna implements Coluna<GrupoDocumento> {

    CODIGO(0, 4750, "Código") {
      @Override
      public String getValor(GrupoDocumento item) {
        return item.getCodigo();
      }
    },
    NOME(1, 4750, "Nome") {
      @Override
      public String getValor(GrupoDocumento item) {
        return item.getNome();
      }
    },
    SITUACAO(2, 4750, "Situação") {
      @Override
      public String getValor(GrupoDocumento item) {
        return item.getSituacao().getDescription();
      }
    };

    private int index;
    private int tamanho;
    private String titulo;

    GrupoDocumentoReportExcelColuna(int index, int tamanho, String titulo) {
      this.index = index;
      this.titulo = titulo;
      this.tamanho = tamanho;
    }
  }
}
