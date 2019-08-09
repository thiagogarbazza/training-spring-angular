package com.github.thiagogarbazza.training.springangular.report.documentodispensado.impl;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensado;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoConsultaService;
import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.report.documentodispensado.DocumentoDispensadoRelatorioService;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.stereotype.Service;

import java.util.Collection;
import javax.inject.Inject;

@Service
class DocumentoDispensadoRelatorioServiceImpl implements DocumentoDispensadoRelatorioService {

  @Inject
  private DocumentoDispensadoConsultaService documentoDispensadoConsultaService;

  @Override
  public ArquivoUpload gerarRelatorioExcel(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    final Collection<DocumentoDispensado> documentoDispensados = documentoDispensadoConsultaService.pesquisar(filtroConsulta);

    return new DocumentoDispensadoRelatorioExcel(documentoDispensados).construirEGerar();
  }
}
