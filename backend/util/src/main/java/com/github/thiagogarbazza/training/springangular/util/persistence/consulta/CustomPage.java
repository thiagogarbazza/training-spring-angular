package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import com.github.thiagogarbazza.simplemessage.SimpleMessages;
import lombok.Getter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
public class CustomPage<T> {

  private final Collection<T> content;
  private final Integer contentSize;
  private final Boolean hasContent;
  private final Boolean hasNext;
  private final Boolean hasPrevious;
  private final Boolean isEmpty;
  private final Boolean isFirst;
  private final Boolean isLast;
  private final SimpleMessages messages;
  private final Integer number;
  private final Map<String, Object> parameters;
  private final Integer size;
  private final Long totalElements;
  private final Integer totalPages;

  public CustomPage(final Collection<T> content, final long total, final Pageable pageable) {
    this.content = content;
    this.contentSize = content.size();
    this.totalElements = total;

    this.number = pageable.getPageNumber();
    this.size = pageable.getPageSize();
    this.totalPages = BigDecimal.valueOf(this.totalElements).divide(BigDecimal.valueOf(this.size), 0).intValue();

    this.hasContent = CollectionUtils.isNotEmpty(this.content);
    this.hasNext = this.number + 1 < this.totalPages;
    this.hasPrevious = this.number > 0;
    this.isEmpty = !this.hasContent;
    this.isFirst = !this.hasPrevious;
    this.isLast = !this.hasNext;

    this.messages = new SimpleMessages();
    this.parameters = new HashMap<>();

    if (this.isEmpty) {
      addMessage(new SimpleMessage(SimpleMessageType.INFORMATION, "page.empty", "Não há resultados para os dados da pesquisa"));
    }
  }

  public void addMessage(final SimpleMessage mensagem) {
    this.messages.add(mensagem);
  }

  public void addParameter(final String key, final Object value) {
    this.parameters.put(key, value);
  }
}
