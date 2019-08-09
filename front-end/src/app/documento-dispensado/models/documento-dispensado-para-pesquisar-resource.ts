import { CustomPageResource } from '@shared/models/custom-page-resource';

import { ClienteParaSelecaoResource } from '@app/cliente/models/cliente-para-selecao-resource';
import { DocumentoParaSelecaoResource } from '@app/documento/models/documento-para-selecao-resource';
import { GrupoDocumentoParaSelecaoResource } from '@app/grupo-documento/models/grupo-documento-para-selecao-resource';
import { SituacaoDocumentoDispensado } from '@app/documento-dispensado/models/situacao-documento-dispensado';
import { DocumentoDispensadoResultadoPesquisaResource } from '@app/documento-dispensado/models/documento-dispensado-resultado-pesquisa-resource';

export class DocumentoDispensadoParaPesquisarResource {

  public acoes: Acoes;
  public dadosFormulario: DadosFormulario;
  public dadosParaFormulario: DadosParaFormulario;
  public resultadoPesquisa: CustomPageResource<DocumentoDispensadoResultadoPesquisaResource>;
}

export class Acoes {

  public podeCriar: boolean;
  public podeGerarRelatorioExcel: boolean;

  constructor(values: Object) {
    Object.assign(this, values);
  }
}

export class DadosFormulario {

  public clientes: Array<ClienteParaSelecaoResource>;
  public dataBaseFim: Date;
  public dataBaseInicio: Date;
  public documentos: Array<DocumentoParaSelecaoResource>;
  public grupoDocumentos: Array<GrupoDocumentoParaSelecaoResource>;
  public situacaoDocumentoDispensados: Array<SituacaoDocumentoDispensado>;
}

export class DadosParaFormulario {

  public clientes: Array<ClienteParaSelecaoResource>;
  public documentos: Array<DocumentoParaSelecaoResource>;
  public grupoDocumentos: Array<GrupoDocumentoParaSelecaoResource>;
  public situacaoDocumentoDispensados: Array<SituacaoDocumentoDispensado>;
}
