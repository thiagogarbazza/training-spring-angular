package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import org.apache.poi.xssf.usermodel.XSSFColor;

public enum Cores {
  PRETO_SUAVE(29, 27, 16),
  BRANCA(255, 255, 255),
  AZUL(197, 217, 241),
  AZUL_CLARO(141, 180, 226),
  AZUL_CLARO_01(220, 230, 241),
  AZUL_CLARO_02(209, 222, 247),
  AZUL_ESCURO(36, 64, 98),
  CINZA(150, 150, 150),
  CINZA_CLARO(221, 221, 221),
  CINZA_ESCURO(95, 95, 95);

  private byte azul;
  private byte verde;
  private byte vermelho;

  Cores(Integer vermelho, Integer verde, Integer azul) {
    this.vermelho = vermelho.byteValue();
    this.verde = verde.byteValue();
    this.azul = azul.byteValue();
  }

  private byte[] getRGB() {
    return new byte[] {vermelho, verde, azul};
  }

  public XSSFColor getXSSFColor() {
    return null; //new XSSFColor(this.getRGB());
  }
}
