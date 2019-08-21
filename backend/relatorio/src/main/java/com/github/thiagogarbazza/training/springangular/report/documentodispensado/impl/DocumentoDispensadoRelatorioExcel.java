package com.github.thiagogarbazza.training.springangular.report.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.AbstractRelatorioExcel;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.Coluna;
import com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelTableBuilder;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Collection;

import static com.github.thiagogarbazza.training.springangular.util.calendario.PeriodoUtil.periodoToString;
import static java.util.Arrays.asList;

class DocumentoDispensadoRelatorioExcel extends AbstractRelatorioExcel {

  private final Collection<DocumentoDispensado> itens;

  DocumentoDispensadoRelatorioExcel(Collection<DocumentoDispensado> itens) {
    super("documentos-dispensados");
    this.itens = itens;
  }

  @Override
  protected void buildSheets() {
    final Sheet sheet = newSheet("documentos-dispensados");

    ExcelTableBuilder.<DocumentoDispensado>builder()
      .sheet(sheet)
      .rowStart(0)
      .colStart(0)
      .title("Documentos dispensados")
      .colunas(asList(DocumentoDispensadoRelatorioExcelColuna.values()))
      .items(this.itens)
      .build();
  }

  @Getter
  private enum DocumentoDispensadoRelatorioExcelColuna implements Coluna<DocumentoDispensado> {

    GRUPO_DOCUMENTO(0, 4750, "Grupo documento") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getDocumento().getGrupoDocumento().getNome();
      }
    },
    DOCUMENTO(1, 4750, "Documento") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getDocumento().getNome();
      }
    },
    CLIENTE(2, 4750, "Cliente") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return item.getCliente().getNome();
      }
    },
    VIGENCIA(3, 4750, "Vigência") {
      @Override
      public String getValor(DocumentoDispensado item) {
        return periodoToString(item.getVigencia());
      }
    },
    SITUACAO(4, 4750, "Situação") {
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
