package com.github.thiagogarbazza.training.springangular.util.persistence.consulta;

import com.github.thiagogarbazza.simplemessage.SimpleMessage;
import com.github.thiagogarbazza.simplemessage.SimpleMessageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomPageTest {

  @Test
  @DisplayName("Verificando quando é passado no construtor um conjunto de itens vazio e o total igual a ZERO.")
  void verificar01() {
    final Collection<String> content = Collections.emptyList();
    final long totalElements = 0;
    final Pageable pageable = QPageRequest.of(0, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(0, page.getContentSize());
    assertFalse(page.getHasContent());
    assertFalse(page.getHasNext());
    assertFalse(page.getHasPrevious());
    assertTrue(page.getIsEmpty());
    assertTrue(page.getIsFirst());
    assertTrue(page.getIsLast());
    assertEquals(0, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(0, page.getTotalElements());
    assertEquals(0, page.getTotalPages());
    assertEquals(1, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor um conjunto de itens vazio e o total maior que ZERO.")
  void verificar02() {
    final Collection<String> content = Collections.emptyList();
    final long totalElements = 1;
    final Pageable pageable = QPageRequest.of(0, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(0, page.getContentSize());
    assertFalse(page.getHasContent());
    assertFalse(page.getHasNext());
    assertFalse(page.getHasPrevious());
    assertTrue(page.getIsEmpty());
    assertTrue(page.getIsFirst());
    assertTrue(page.getIsLast());
    assertEquals(0, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(1, page.getTotalElements());
    assertEquals(1, page.getTotalPages());
    assertEquals(1, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor com 1 item.")
  void verificar03() {
    final Collection<String> content = Arrays.asList("Item 01");
    final long totalElements = 1;
    final Pageable pageable = QPageRequest.of(0, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(1, page.getContentSize());
    assertTrue(page.getHasContent());
    assertFalse(page.getHasNext());
    assertFalse(page.getHasPrevious());
    assertFalse(page.getIsEmpty());
    assertTrue(page.getIsFirst());
    assertTrue(page.getIsLast());
    assertEquals(0, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(1, page.getTotalElements());
    assertEquals(1, page.getTotalPages());
    assertEquals(0, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor com n item.")
  void verificar04() {
    final Collection<String> content = Arrays.asList("Item 01", "Item 02", "Item 03");
    final long totalElements = 3;
    final Pageable pageable = QPageRequest.of(0, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(3, page.getContentSize());
    assertTrue(page.getHasContent());
    assertFalse(page.getHasNext());
    assertFalse(page.getHasPrevious());
    assertFalse(page.getIsEmpty());
    assertTrue(page.getIsFirst());
    assertTrue(page.getIsLast());
    assertEquals(0, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(3, page.getTotalElements());
    assertEquals(1, page.getTotalPages());
    assertEquals(0, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor n itens com um total de elementos que gere várias páginas e estamos na primeira página.")
  void verificar05() {
    final Collection<String> content = Arrays.asList("Item 01", "Item 02", "Item 03");
    final long totalElements = 11;
    final Pageable pageable = QPageRequest.of(0, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(3, page.getContentSize());
    assertTrue(page.getHasContent());
    assertTrue(page.getHasNext());
    assertFalse(page.getHasPrevious());
    assertFalse(page.getIsEmpty());
    assertTrue(page.getIsFirst());
    assertFalse(page.getIsLast());
    assertEquals(0, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(11, page.getTotalElements());
    assertEquals(4, page.getTotalPages());
    assertEquals(0, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor n itens com um total de elementos que gere várias páginas e estamos na 03 página.")
  void verificar06() {
    final Collection<String> content = Arrays.asList("Item 07", "Item 08", "Item 09");
    final long totalElements = 11;
    final Pageable pageable = QPageRequest.of(2, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(3, page.getContentSize());
    assertTrue(page.getHasContent());
    assertTrue(page.getHasNext());
    assertTrue(page.getHasPrevious());
    assertFalse(page.getIsEmpty());
    assertFalse(page.getIsFirst());
    assertFalse(page.getIsLast());
    assertEquals(2, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(11, page.getTotalElements());
    assertEquals(4, page.getTotalPages());
    assertEquals(0, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificando quando é passado no construtor n itens com um total de elementos que gere várias páginas e estamos na última página.")
  void verificar07() {
    final Collection<String> content = Arrays.asList("Item 10", "Item 11");
    final long totalElements = 11;
    final Pageable pageable = QPageRequest.of(4, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertEquals(content, page.getContent());
    assertEquals(2, page.getContentSize());
    assertTrue(page.getHasContent());
    assertFalse(page.getHasNext());
    assertTrue(page.getHasPrevious());
    assertFalse(page.getIsEmpty());
    assertFalse(page.getIsFirst());
    assertTrue(page.getIsLast());
    assertEquals(4, page.getNumber());
    assertEquals(3, page.getSize());
    assertEquals(11, page.getTotalElements());
    assertEquals(4, page.getTotalPages());
    assertEquals(0, page.getMessages().size());
    assertEquals(0, page.getParameters().size());
  }

  @Test
  @DisplayName("Verificar mensagem quando não existir resultado.")
  void verificar90() {
    final Collection<String> content = Collections.emptyList();
    final long totalElements = 0;
    final Pageable pageable = QPageRequest.of(4, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    assertTrue(page.getIsEmpty());
    assertEquals(1, page.getMessages().size());
    final SimpleMessage simpleMessage = page.getMessages().iterator().next();
    assertEquals(SimpleMessageType.INFORMATION, simpleMessage.getType());
    assertEquals("page.empty", simpleMessage.getKey());
    assertEquals("Não há resultados para os dados da pesquisa", simpleMessage.getContent());
  }

  @Test
  @DisplayName("Verificar adicção de parâmetros à página.")
  void verificar91() {
    final Collection<String> content = Collections.emptyList();
    final long totalElements = 0;
    final Pageable pageable = QPageRequest.of(4, 3);

    CustomPage<String> page = new CustomPage<>(content, totalElements, pageable);

    page.addParameter("page.any-key", "page.any-value");
    assertEquals(1, page.getParameters().size());
    assertEquals("page.any-value", page.getParameters().get("page.any-key"));
  }
}
