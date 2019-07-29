package com.github.thiagogarbazza.training.springangular.util.strategy;

import java.util.Set;

/**
 * Define uma forma para escolha de estratégias (implementações) de um determinado tipo baseada em
 * qualificadores em tempo de execução. Pode ser usada, por exemplo, se uma interface tem duas ou mais
 * implementações e a escolha da implementação a ser utilizada é definida por uma string, ou qualquer outro
 * tipo, cujo valor só está disponível no exato momento de uso, desta forma não se conhece qual delas injetar
 * via autowired no startup, logo esta interface pode ser uma estratégia qualificada.
 *
 * @param <Q> Tipo do qualificador da estratégia.
 *
 * @see AbstractSimpleQualifierStrategyManager Gerenciador de estratégias.
 */
public interface SimpleQualifierStrategy<Q> {

  /**
   * @return Qualificadores a serem associados à estratégia. Sempre que for necesssário instanciar qualquer implementação do tipo da estratégia, um destes
   * qualificadores deve ser usado para determinar qual delas será usada.
   */
  Set<Q> qualifiers();
}
