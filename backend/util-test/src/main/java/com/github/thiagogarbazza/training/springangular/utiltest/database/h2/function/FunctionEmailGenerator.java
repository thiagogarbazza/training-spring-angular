package com.github.thiagogarbazza.training.springangular.utiltest.database.h2.function;

import com.github.thiagogarbazza.training.springangular.utiltest.randon.RandonUtil;
import com.thedeanda.lorem.LoremIpsum;
import lombok.experimental.UtilityClass;

import java.sql.SQLException;

@UtilityClass
public class FunctionEmailGenerator {

  public static String executar(int charLentgth) throws SQLException {
    final int quantidade = RandonUtil.randonValue(0, charLentgth / 4);
    final int tamanho = RandonUtil.randonValue(charLentgth / 2, charLentgth);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < quantidade; i++) {
      final String email = LoremIpsum.getInstance().getEmail();
      if (sb.length() + email.length() > tamanho) {
        break;
      }

      if (sb.length() > 0) {
        sb.append(",");
      }

      sb.append(email);
    }

    return sb.toString();
  }
}
