package com.github.thiagogarbazza.training.springangular.util.arquivo;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArquivoUploadD4T {

  public static ArquivoUpload arquivoUploadExcel() {
    return ArquivoUpload.builder()
      .extensao(Extensoes.EXTENSAO_PLANILHA)
      .mimetype(Mimetypes.MIMETYPE_PLANILHA)
      .nome("nome-qualquer-para-o-arquivo")
      .conteudo("conteúdo do arquivo".getBytes())
      .build();
  }
}
