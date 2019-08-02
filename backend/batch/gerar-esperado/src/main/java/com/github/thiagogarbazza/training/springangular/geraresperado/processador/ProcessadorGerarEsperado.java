package com.github.thiagogarbazza.training.springangular.geraresperado.processador;

import com.github.thiagogarbazza.training.springangular.batchcomum.processamento.Processador;

abstract class ProcessadorGerarEsperado implements Processador<DadosGeracaoEsperado> {

  static final int PASSO_BUSCAR_CLIENTE = 1;
  static final int PASSO_BUSCAR_DISPENSAS = 2;
  static final int PASSO_GERAR_ESPERADO = 99;
  static final int PASSO_VERIFICAR_DATA_REFERENCIA = 0;
}
