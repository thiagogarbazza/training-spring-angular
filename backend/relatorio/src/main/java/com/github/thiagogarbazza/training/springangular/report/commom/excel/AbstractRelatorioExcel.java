package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import com.github.thiagogarbazza.training.springangular.report.ReportException;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import com.github.thiagogarbazza.training.springangular.util.arquivo.Extensoes;
import com.github.thiagogarbazza.training.springangular.util.arquivo.Mimetypes;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static lombok.AccessLevel.PROTECTED;

public abstract class AbstractRelatorioExcel {

  public static final int ROW_ACCESS_WINDOW_SIZE = 10000;
  private final String nome;
  private Integer linhaAtualId = 0;
  @Getter
  @Setter(PROTECTED)
  private SXSSFWorkbook workbook;

  protected AbstractRelatorioExcel(String nome) {
    this.nome = nome;
    this.workbook = new SXSSFWorkbook(ROW_ACCESS_WINDOW_SIZE);
  }

  protected abstract void construir();

  public final ArquivoUpload construirEGerar() {
    construir();
    return gerar();
  }

  public final ArquivoUpload gerar() {
    return ArquivoUpload.builder()
      .mimetype(Mimetypes.MIMETYPE_PLANILHA)
      .extensao(Extensoes.EXTENSAO_PLANILHA)
      .nome(this.nome)
      .conteudo(conteudoBuild(workbook))
      .build();
  }

  protected Row criarLinha() {
    linhaAtualId++;
    return mainSheet().createRow(linhaAtualId);
  }

  protected Row criarLinhaEmBranco() {
    return criarLinhaEmBranco(1);
  }

  protected Row criarLinhaEmBranco(int quantidade) {
    linhaAtualId += quantidade;
    return mainSheet().createRow(linhaAtualId);
  }

  protected Sheet criarSheete() {
    SXSSFSheet sheet = workbook.createSheet();
    sheet.setDisplayGridlines(false);
    return sheet;
  }

  protected Sheet criarSheete(String nomeSheet) {
    SXSSFSheet sheet = workbook.createSheet(nomeSheet);
    sheet.setDisplayGridlines(false);
    return sheet;
  }

  protected Row linha(int number) {
    return mainSheet().getRow(number);
  }

  protected Sheet mainSheet() {
    return workbook.getSheetAt(0);
  }

  protected Cell preencherCelula(Row linha, Integer index, String valor, CellStyle estiloDaLinha) {
    final Cell cell = linha.createCell(index);

    cell.setCellValue(valor);
    cell.setCellStyle(estiloDaLinha);

    return cell;
  }

  private byte[] conteudoBuild(SXSSFWorkbook workbook) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    try {
      workbook.write(bos);
    } catch (IOException e) {
      throw new ReportException("Erro ao gerar relatório em excel", e);
    }

    return bos.toByteArray();
  }
}
