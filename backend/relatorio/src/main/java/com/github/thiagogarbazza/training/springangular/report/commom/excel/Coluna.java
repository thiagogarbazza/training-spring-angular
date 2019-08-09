package com.github.thiagogarbazza.training.springangular.report.commom.excel;

public interface Coluna<T> {

  /**
   * @return index - the column to set (0-based)
   *
   * @see org.apache.poi.ss.usermodel.Sheet#setColumnWidth
   */
  int getIndex();

  /**
   * @return tamanho - the width in units of 1/256th of a character width
   *
   * @see org.apache.poi.ss.usermodel.Sheet#setColumnWidth
   */
  int getTamanho();

  String getTitulo();

  String getValor(T t);
}
