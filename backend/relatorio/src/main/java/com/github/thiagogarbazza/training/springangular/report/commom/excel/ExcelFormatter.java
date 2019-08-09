package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;

@UtilityClass
public class ExcelFormatter {

  public static void formataCelularEstilo(final XSSFCellStyle style, final XSSFFont fonte, final HorizontalAlignment align, final VerticalAlignment vAlign,
    final XSSFColor color, boolean wrapped, short fp) {
    style.setFont(fonte);
    style.setAlignment(align);
    style.setVerticalAlignment(vAlign);
    style.setFillForegroundColor(color);
    style.setWrapText(wrapped);
  }

  public static void formataFonte(final XSSFFont fonte, double height, final XSSFColor color, boolean bold,
    short boldweight) {
    fonte.setFontHeight(height);
    fonte.setColor(color);
    fonte.setBold(bold);
  }

  public static void setBorderIn(final XSSFCellStyle cellStyle, final BorderStyle borderStyle, final Cores cor) {
    cellStyle.setBorderTop(borderStyle);
    cellStyle.setTopBorderColor(cor.getXSSFColor());

    cellStyle.setBorderRight(borderStyle);
    cellStyle.setRightBorderColor(cor.getXSSFColor());

    cellStyle.setBorderBottom(borderStyle);
    cellStyle.setBottomBorderColor(cor.getXSSFColor());

    cellStyle.setBorderLeft(borderStyle);
    cellStyle.setLeftBorderColor(cor.getXSSFColor());
  }
}
