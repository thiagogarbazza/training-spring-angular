package com.github.thiagogarbazza.training.springangular.rest.controller.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.report.documentodispensado.DocumentoDispensadoRelatorioService;
import com.github.thiagogarbazza.training.springangular.rest.comum.arquivo.ArquivoUploadResource;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
class DocumentoDispensadoGerarRelatorioExcelService {

  @Inject
  DocumentoDispensadoRelatorioService documentoDispensadoRelatorioService;

  ArquivoUploadResource gerar(final DocumentoDispensadoFiltroConsulta filtroConsulta) {
    final ArquivoUpload arquivoUpload = documentoDispensadoRelatorioService.gerarRelatorioExcel(filtroConsulta);
    return new ArquivoUploadResource(arquivoUpload);
  }
}
