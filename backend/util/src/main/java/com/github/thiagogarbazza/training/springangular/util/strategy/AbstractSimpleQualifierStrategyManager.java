package com.github.thiagogarbazza.training.springangular.util.strategy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.text.MessageFormat.format;

/**
 * Implementação básica para gerenciamento de estratégias de um determinado tipo baseada em qualificadores em
 * tempo de execução.
 *
 * @param <Q> Tipo do qualificador da estratégia.
 * @param <S> Tipo do conjunto de estratégias.
 *
 * @see SimpleQualifierStrategy
 */
public abstract class AbstractSimpleQualifierStrategyManager<Q, S extends SimpleQualifierStrategy<Q>> implements SimpleQualifierStrategyManager<Q, S> {

  private final Map<Q, S> strategies;

  /**
   * @param strategies Todas as implementações do tipo da estratégia definida.
   * Sugestão: injete todas elas diretamente via @javax.inject.Inject no construtor das classes filhas.
   *
   * @throws UnsupportedOperationException Se um mesmo qualificador se associar a mais de uma estratégia.
   */
  public AbstractSimpleQualifierStrategyManager(Collection<S> strategies) {
    this.strategies = mapBuild(strategies);
  }

  /**
   * @return Estratégia correspondente ao qualificador informado.
   *
   * @throws UnsupportedOperationException Se qualificador não estiver associado a nehuma estratégia.
   */
  @Override
  public S strategy(final Q q) {
    if (!strategies.containsKey(q)) {
      return defaultStrategy(q);
    }

    return strategies.get(q);
  }

  /**
   * Método gancho. Sobrescreva para alterar o comportamento quando uma estratégia não é encontrada.
   */
  protected S defaultStrategy(final Q q) {
    throw new UnsupportedOperationException(format("Strategy not registered for qualifier {0}.", q));
  }

  private Map<Q, S> mapBuild(final Collection<S> strategies) {
    final Map<Q, S> mapeamento = new HashMap<>();

    for (final S strategy : strategies) {
      for (final Q qualifier : strategy.qualifiers()) {
        if (mapeamento.containsKey(qualifier)) {
          final S otherStrategy = mapeamento.get(qualifier);
          throw new UnsupportedOperationException(
            format("Qualifier {0} is already associated with the {1} strategy.", qualifier, otherStrategy.getClass().getName()));
        }

        mapeamento.put(qualifier, strategy);
      }
    }

    return mapeamento;
  }
}
