package com.github.thiagogarbazza.training.springangular.rest.comum.arquivo;

import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ArquivoUploadResource extends ResponseEntity<byte[]> {

  public ArquivoUploadResource(final ArquivoUpload arquivoUpload) {
    super(arquivoUpload.getConteudo(), httpHeadersBuild(arquivoUpload), HttpStatus.OK);
  }

  private static ContentDisposition contentDispositionBuild(final ArquivoUpload arquivoUpload) {
    return ContentDisposition.builder("attachment")
      .filename(arquivoUpload.filename())
      .build();
  }

  private static HttpHeaders httpHeadersBuild(final ArquivoUpload arquivoUpload) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.valueOf(arquivoUpload.getMimetype()));
    httpHeaders.setContentLength(arquivoUpload.getConteudo().length);
    httpHeaders.setContentDisposition(contentDispositionBuild(arquivoUpload));

    return httpHeaders;
  }
}
