package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ExcelTableBuilder<T> {

  private int colStart = 0;
  private Collection<Coluna<T>> colunas;
  private Collection<T> items;
  private int rowIndex = 0;
  private int rowStart = 0;
  private Sheet sheet;
  private String title;

  public static ExcelTableBuilder builder() {
    return new ExcelTableBuilder();
  }

  public void build() {
    createTitle();
    createHeader();
    createBody();
  }

  public ExcelTableBuilder colStart(int colStart) {
    this.colStart = colStart;

    return this;
  }

  public ExcelTableBuilder colunas(Collection<Coluna<T>> colunas) {
    this.colunas = colunas;

    return this;
  }

  public ExcelTableBuilder items(Collection<T> items) {
    this.items = items;

    return this;
  }

  public ExcelTableBuilder rowStart(int rowStart) {
    this.rowStart = rowStart;
    this.rowIndex = rowStart;

    return this;
  }

  public ExcelTableBuilder sheet(Sheet sheet) {
    this.sheet = sheet;

    return this;
  }

  public ExcelTableBuilder title(String title) {
    this.title = title;

    return this;
  }

  private void createBody() {
    final CellStyle cellStyleOdd = ExcelStyleCell.excelStyleCell(this.sheet.getWorkbook(), "app.excel.style.table.body-row-odd");
    final CellStyle cellStyleEven = ExcelStyleCell.excelStyleCell(this.sheet.getWorkbook(), "app.excel.style.table.body-row-even");

    this.items.forEach(item -> {
      final Row row = this.sheet.createRow(this.rowIndex++);
      final CellStyle cellStyle = row.getRowNum() % 2 == 0 ? cellStyleOdd : cellStyleEven;

      this.colunas.forEach(coluna -> {
        final Cell cell = row.createCell(this.colStart + coluna.getIndex());
        cell.setCellValue(coluna.getValor(item));
        cell.setCellStyle(cellStyle);
      });
    });
  }

  private void createHeader() {
    final Row row = this.sheet.createRow(this.rowIndex++);
    final CellStyle cellStyle = ExcelStyleCell.excelStyleCell(this.sheet.getWorkbook(), "app.excel.style.table.header");

    this.colunas.forEach(coluna -> {
      Cell cell = row.createCell(this.colStart + coluna.getIndex());
      cell.setCellValue(coluna.getTitulo());
      cell.setCellStyle(cellStyle);

      sheet.setColumnWidth(coluna.getIndex(), coluna.getTamanho());
    });
  }

  private void createTitle() {
    final Row row = this.sheet.createRow(this.rowIndex++);
    final XSSFCellStyle cellStyle = ExcelStyleCell.excelStyleCell(this.sheet.getWorkbook(), "app.excel.style.table.title");

    Cell cell = row.createCell(this.colStart);
    cell.setCellValue(this.title);
    cell.setCellStyle(cellStyle);

    final CellRangeAddress cellAddresses = new CellRangeAddress(row.getRowNum(), row.getRowNum(), this.colStart, this.colStart + this.colunas.size() - 1);
    sheet.addMergedRegion(cellAddresses);
  }
}
