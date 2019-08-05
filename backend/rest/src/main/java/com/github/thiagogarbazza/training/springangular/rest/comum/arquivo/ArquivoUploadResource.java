package com.github.thiagogarbazza.training.springangular.rest.comum.arquivo;

import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class ArquivoUploadResource extends ResponseEntity<byte[]> {

  public ArquivoUploadResource(final ArquivoUpload arquivoUpload) {
    super(arquivoUpload.getConteudo(), buildHTTPHHeader(arquivoUpload), HttpStatus.OK);
  }

  private static HttpHeaders buildHTTPHHeader(final ArquivoUpload arquivoUpload) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.valueOf(arquivoUpload.getMimetype()));
    httpHeaders.setContentLength(arquivoUpload.getConteudo().length);
    httpHeaders.set("content-disposition", "attachment; filename=" + arquivoUpload.filename());

    return httpHeaders;
  }
}
