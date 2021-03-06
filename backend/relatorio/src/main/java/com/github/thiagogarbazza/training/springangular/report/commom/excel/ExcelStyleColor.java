package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import lombok.experimental.UtilityClass;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;

import java.awt.*;

@UtilityClass
public class ExcelStyleColor {

  public static XSSFColor newColor(final String color) {
    return new XSSFColor(Color.decode(color), new DefaultIndexedColorMap());
  }
}
