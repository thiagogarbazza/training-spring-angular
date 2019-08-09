package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class ExcelUtils {

  private static final int TAM_FONTE_10 = 10;
  private static final int TAM_FONTE_16 = 16;
  private static final int TAM_FONTE_8 = 8;
  private static final int TAM_FONTE_9 = 9;

  public static XSSFCellStyle createCellStyle(final SXSSFWorkbook workbook) {
    final XSSFFont font = criarFontCalibri(workbook);

    final XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
    cellStyle.setAlignment(HorizontalAlignment.LEFT);
    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    cellStyle.setFont(font);

    return cellStyle;
  }

  public static XSSFCellStyle createCellStyleComun(final SXSSFWorkbook workbook) {
    XSSFCellStyle cellStyle = createCellStyle(workbook);
    cellStyle.getFont().setFontHeight(TAM_FONTE_10);

    return cellStyle;
  }

  public static XSSFCellStyle createCellStyleComunNegrito(final SXSSFWorkbook workbook) {
    XSSFCellStyle cellStyle = createCellStyleComun(workbook);
    cellStyle.getFont().setBold(true);

    return cellStyle;
  }

  public static XSSFCellStyle criarEstiloLegendaTabela(final SXSSFWorkbook workbook) {
    final XSSFFont font = criarFontCalibri(workbook);
    font.setFontHeight(TAM_FONTE_8);

    final XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
    style.setFont(font);

    return style;
  }

  public static XSSFCellStyle criarEstiloTabelaCabecalho01(final SXSSFWorkbook workbook) {
    final XSSFFont font = criarFontCalibri(workbook);
    //formataFonte(font, TAM_FONTE_10, Cores.BRANCA.getXSSFColor(), true, Font.BOLDWEIGHT_BOLD);

    final XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
    //formataCelularEstilo(style, font, HorizontalAlignment.CENTER, VerticalAlignment.CENTER,
    //  Cores.AZUL_ESCURO.getXSSFColor(), true, CellStyle.SOLID_FOREGROUND);

    //setBorderIn(style, BorderStyle.THIN, Cores.CINZA);

    return style;
  }

  public static XSSFCellStyle criarEstiloTabelaCabecalho02(final SXSSFWorkbook workbook) {
    final XSSFCellStyle cellStyle = criarEstiloTabelaCabecalho01(workbook);
    cellStyle.getFont().setFontHeight(TAM_FONTE_9);
    cellStyle.setFillForegroundColor(Cores.AZUL_CLARO.getXSSFColor());

    return cellStyle;
  }

  public static XSSFCellStyle criarEstiloTabelaCelula(final SXSSFWorkbook workbook) {
    final XSSFCellStyle cellStyle = createCellStyle(workbook);
    cellStyle.getFont().setFontHeight(TAM_FONTE_8);
    cellStyle.setWrapText(true);
    //setBorderIn(cellStyle, BorderStyle.THIN, Cores.CINZA);
    return cellStyle;
  }

  public static XSSFCellStyle criarEstiloTabelaCelulaNao(final SXSSFWorkbook workbook) {
    final XSSFCellStyle cellStyle = criarEstiloTabelaCelula(workbook);
    cellStyle.setFillForegroundColor(Cores.AZUL_CLARO_02.getXSSFColor());
    //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    return cellStyle;
  }

  public static XSSFCellStyle criarEstiloTabelaCelulaSim(final SXSSFWorkbook workbook) {
    final XSSFCellStyle cellStyle = criarEstiloTabelaCelula(workbook);
    cellStyle.setFillForegroundColor(Cores.AZUL_CLARO_01.getXSSFColor());
    //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
    return cellStyle;
  }

  public static XSSFCellStyle criarEstiloTitulo(final SXSSFWorkbook workbook) {
    XSSFCellStyle cellStyle = createCellStyle(workbook);
    cellStyle.getFont().setFontHeight(TAM_FONTE_16);
    cellStyle.getFont().setBold(true);
    // cellStyle.getFont().setBoldweight(BOLDWEIGHT_BOLD);
    // cellStyle.setAlignment(LEFT);

    return cellStyle;
  }

  public static XSSFFont criarFontCalibri(final SXSSFWorkbook workbook) {
    XSSFFont font = (XSSFFont) workbook.createFont();

    font.setFontName("Calibri");
    font.setFontHeight(TAM_FONTE_8);
    font.setBold(false);

    return font;
  }
}
