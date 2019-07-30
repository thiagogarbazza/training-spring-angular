package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import com.github.thiagogarbazza.simplemessage.SimpleMessages;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CustomPage<T> extends PageImpl<T> {

  @Getter
  private final SimpleMessages messages;

  public CustomPage(List<T> content, Pageable pageable, long total) {
    super(content, pageable, total);
    this.messages = new SimpleMessages();

    if (CollectionUtils.isEmpty(content)) {
      addMessage(new SimpleMessage(SimpleMessageType.INFORMATION, "pagina-vazia", "Não há resultados para os dados de pesquisa."));
    }
  }

  public void addMessage(SimpleMessage mensagem) {
    this.messages.add(mensagem);
  }
}
