package com.github.thiagogarbazza.training.springangular.util.strategy;

/**
 * Implementação básica para gerenciamento de estratégias de um determinado tipo baseada em qualificadores em
 * tempo de execução.
 *
 * @param <Q> Tipo do qualificador da estratégia.
 * @param <S> Tipo do conjunto de estratégias.
 *
 * @see SimpleQualifierStrategy
 */
public interface SimpleQualifierStrategyManager<Q, S extends SimpleQualifierStrategy<Q>> {

  /**
   * @return Estratégia correspondente ao qualificador informado.
   *
   * @throws UnsupportedOperationException Se qualificador não estiver associado a nehuma estratégia.
   */
  S strategy(Q q);
}
