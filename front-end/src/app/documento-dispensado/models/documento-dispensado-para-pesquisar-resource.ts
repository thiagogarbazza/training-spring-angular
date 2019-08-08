import { CustomPageResource } from '@shared/models/custom-page-resource';
import { DocumentoDispensadoResultadoPesquisaResource } from './documento-dispensado-resultado-pesquisa-resource';

export class DocumentoDispensadoParaPesquisarResource {

  acoes: Acoes;
  resultadoPesquisa: CustomPageResource<DocumentoDispensadoResultadoPesquisaResource>;


}

 export class Acoes {

  public podeGerarExcel: boolean;
  public podeIncluir: boolean;
}
