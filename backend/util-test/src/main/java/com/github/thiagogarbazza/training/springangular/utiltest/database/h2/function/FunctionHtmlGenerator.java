package com.github.thiagogarbazza.training.springangular.utiltest.database.h2.function;

import com.github.thiagogarbazza.training.springangular.utiltest.randon.RandonUtil;
import com.thedeanda.lorem.LoremIpsum;
import lombok.experimental.UtilityClass;

import java.sql.SQLException;

@UtilityClass
public class FunctionHtmlGenerator {

  public static String executar(int charLentgth) throws SQLException {
    final int tamanho = RandonUtil.randonValue(charLentgth / 2, charLentgth);

    final String htmlParagraphs = LoremIpsum.getInstance().getHtmlParagraphs(1, tamanho / 2);

    return htmlParagraphs.substring(0, tamanho);
  }
}
