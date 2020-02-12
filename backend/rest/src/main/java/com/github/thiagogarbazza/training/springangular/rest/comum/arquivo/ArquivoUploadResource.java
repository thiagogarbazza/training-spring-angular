package com.github.thiagogarbazza.training.springangular.rest.comum.arquivo;

import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ArquivoUploadResource extends ResponseEntity<byte[]> {

  private ArquivoUploadResource(final ArquivoUpload arquivoUpload, final byte[] conteudo) {
    super(conteudo, httpHeadersBuild(arquivoUpload, conteudo), HttpStatus.OK);
  }

  public static ArquivoUploadResource of(final ArquivoUpload arquivoUpload) {
    return new ArquivoUploadResource(arquivoUpload, arquivoUpload.getConteudo().toByteArray());
  }

  private static ContentDisposition contentDispositionBuild(final ArquivoUpload arquivoUpload) {
    return ContentDisposition.builder("attachment")
      .filename(arquivoUpload.filename())
      .build();
  }

  private static HttpHeaders httpHeadersBuild(final ArquivoUpload arquivoUpload, final byte[] conteudo) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.valueOf(arquivoUpload.getMimetype()));
    httpHeaders.setContentLength(conteudo.length);
    httpHeaders.setContentDisposition(contentDispositionBuild(arquivoUpload));

    return httpHeaders;
  }
}
