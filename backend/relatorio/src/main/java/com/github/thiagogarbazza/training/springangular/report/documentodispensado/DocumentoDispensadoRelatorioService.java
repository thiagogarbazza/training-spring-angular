package com.github.thiagogarbazza.training.springangular.report.documentodispensado;

import com.github.thiagogarbazza.training.springangular.core.documentodispensado.DocumentoDispensadoFiltroConsulta;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;

public interface DocumentoDispensadoRelatorioService {

  ArquivoUpload gerarRelatorioExcel(DocumentoDispensadoFiltroConsulta filtroConsulta);
}
