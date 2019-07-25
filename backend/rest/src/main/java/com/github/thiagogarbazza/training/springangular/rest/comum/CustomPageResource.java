package com.github.thiagogarbazza.training.springangular.rest.comum;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CustomPageResource<T> {

  private Collection<T> content;
  private Integer contentSize;
  private boolean hasContent;
  private boolean hasNext;
  private boolean hasPrevious;
  private boolean isFirst;
  private boolean isLast;
  private Collection<SimpleMessage> messages;
  private Integer pageNext;
  private Integer pageNumber;
  private Integer pagePrevious;
  private Integer pageSize;
  private Map<String, Object> parameters = new HashMap<>();
  private Long totalElements;
  private Integer totalPages;
}
