package com.github.thiagogarbazza.training.springangular.utiltest.h2;

import com.github.thiagogarbazza.training.springangular.utiltest.randon.RandonUtil;
import com.thedeanda.lorem.LoremIpsum;
import lombok.experimental.UtilityClass;

import java.sql.SQLException;

@UtilityClass
public class FunctionTextGenerator {

  public static String executar(int charLentgth) throws SQLException {
    final int tamanho = RandonUtil.randonValue(charLentgth / 2, charLentgth);

    final String htmlParagraphs = LoremIpsum.getInstance().getParagraphs(1, tamanho / 2);

    return htmlParagraphs.substring(0, tamanho);
  }
}
