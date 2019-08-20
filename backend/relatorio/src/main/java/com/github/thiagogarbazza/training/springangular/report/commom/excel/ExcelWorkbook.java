package com.github.thiagogarbazza.training.springangular.report.commom.excel;

import com.github.thiagogarbazza.training.springangular.report.ReportException;
import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@UtilityClass
public class ExcelWorkbook {

  public static ByteArrayOutputStream workbookToOutputStream(Workbook workbook) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();

    try {
      workbook.write(bos);
    } catch (IOException e) {
      throw new ReportException("Erro ao gerar relatório em excel", e);
    }

    return bos;
  }
}
