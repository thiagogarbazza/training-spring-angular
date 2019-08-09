import { ClienteParaSelecaoResource } from '@app/cliente/models/cliente-para-selecao-resource';
import { DocumentoParaSelecaoResource } from '@app/documento/models/documento-para-selecao-resource';
import { GrupoDocumentoParaSelecaoResource } from '@app/grupo-documento/models/grupo-documento-para-selecao-resource';
import { SituacaoDocumentoDispensado } from './situacao-documento-dispensado';
import { Identifiable } from '@shared/models/identifiable';

export class DocumentoDispensadoResultadoPesquisaResource extends Identifiable {

  public cliente: ClienteParaSelecaoResource;
  public vigenciaFim: Date;
  public vigenciaInicio: Date;
  public documento: DocumentoParaSelecaoResource;
  public grupoDocumento: GrupoDocumentoParaSelecaoResource;
  public situacaoDocumentoDispensado: SituacaoDocumentoDispensado;
}
