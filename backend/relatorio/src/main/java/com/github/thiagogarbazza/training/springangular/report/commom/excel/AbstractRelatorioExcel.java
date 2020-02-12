package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import com.github.thiagogarbazza.training.springangular.util.arquivo.Extensoes;
import com.github.thiagogarbazza.training.springangular.util.arquivo.Mimetypes;
import lombok.Getter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import static com.github.thiagogarbazza.training.springangular.report.commom.excel.ExcelWorkbook.workbookToOutputStream;

public abstract class AbstractRelatorioExcel {

  private static final int ROW_ACCESS_WINDOW_SIZE = 10000;

  private final String fileName;
  @Getter
  private SXSSFWorkbook workbook;

  protected AbstractRelatorioExcel(String fileName) {
    this.fileName = fileName;
    this.workbook = new SXSSFWorkbook(ROW_ACCESS_WINDOW_SIZE);
  }

  protected abstract void buildSheets();

  public final ArquivoUpload build() {
    buildSheets();

    return gerar();
  }

  protected Sheet newSheet(String nomeSheet) {
    Sheet sheet = workbook.createSheet(nomeSheet);
    sheet.setDisplayGridlines(false);

    return sheet;
  }

  private ArquivoUpload gerar() {
    return ArquivoUpload.builder()
      .mimetype(Mimetypes.MIMETYPE_PLANILHA)
      .extensao(Extensoes.EXTENSAO_PLANILHA)
      .nome(this.fileName)
      .conteudo(workbookToOutputStream(workbook))
      .build();
  }
}
