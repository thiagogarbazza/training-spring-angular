package com.github.thiagogarbazza.training.springangular.util.arquivo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SIMPLE_STYLE;

@Getter
@Builder()
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ArquivoUpload {

  private byte[] conteudo;
  private String extensao;
  private String mimetype;
  private String nome;

  @Override
  public String toString() {
    return new ToStringBuilder(this, SIMPLE_STYLE)
      .append(this.nome)
      .append(this.mimetype)
      .append(this.conteudo.length)
      .toString();
  }

  public String filename() {
    return this.nome + "." + this.extensao;
  }
}
