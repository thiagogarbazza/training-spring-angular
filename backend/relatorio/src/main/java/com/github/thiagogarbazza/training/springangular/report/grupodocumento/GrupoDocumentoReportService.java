package com.github.thiagogarbazza.training.springangular.report.grupodocumento;

import com.github.thiagogarbazza.training.springangular.core.grupodocumento.GrupoDocumentoSearchFilter;
import com.github.thiagogarbazza.training.springangular.util.arquivo.ArquivoUpload;

public interface GrupoDocumentoReportService {

  ArquivoUpload excel(GrupoDocumentoSearchFilter grupoDocumentoSearchFilter);
}
