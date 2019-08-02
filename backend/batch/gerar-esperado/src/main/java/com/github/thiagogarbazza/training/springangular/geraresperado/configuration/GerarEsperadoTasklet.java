package com.github.thiagogarbazza.training.springangular.geraresperado.configuration;

import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperado;
import com.github.thiagogarbazza.training.springangular.core.documentoesperado.DocumentoEsperadoConsultaService;
import com.github.thiagogarbazza.training.springangular.geraresperado.processador.GerarEsperadoService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;

@Component
@CommonsLog
class GerarEsperadoTasklet implements Tasklet {

  @Autowired
  private DocumentoEsperadoConsultaService documentoEsperadoConsultaService;
  @Autowired
  private GerarEsperadoService gerarEsperadoService;

  @Override
  public RepeatStatus execute(final StepContribution stepContribution, final ChunkContext chunkContext) throws Exception {
    gerarEsperadoService.processar(LocalDate.now());

    final Collection<DocumentoEsperado> documentoEsperados = documentoEsperadoConsultaService.pesquisar();
    log.info(documentoEsperados.size());
    log.info(documentoEsperados);

    return RepeatStatus.FINISHED;
  }
}
