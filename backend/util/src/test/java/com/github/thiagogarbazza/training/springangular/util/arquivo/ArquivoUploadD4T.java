package com.github.thiagogarbazza.training.springangular.util.arquivo;

import lombok.experimental.UtilityClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@UtilityClass
public class ArquivoUploadD4T {

  public static ArquivoUpload arquivoUploadExcel() {
    final ByteArrayOutputStream conteudo = new ByteArrayOutputStream(5);
    try {
      conteudo.write("conteúdo do arquivo".getBytes());
    } catch (IOException e) {
      // nada aqui...
    }

    return ArquivoUpload.builder()
      .extensao(Extensoes.EXTENSAO_PLANILHA)
      .mimetype(Mimetypes.MIMETYPE_PLANILHA)
      .nome("nome-qualquer-para-o-arquivo")
      .conteudo(conteudo)
      .build();
  }
}
