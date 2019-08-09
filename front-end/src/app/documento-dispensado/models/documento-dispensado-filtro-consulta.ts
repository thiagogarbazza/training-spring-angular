import { AbstractFiltroPaginado } from "@shared/models/abstract-filtro-paginado";

export class DocumentoDispensadoFiltroConsulta extends AbstractFiltroPaginado {

  public clientes: Array<string>
  public documentos: Array<string>;
  public grupoDocumentos: Array<string>;
  public situacoes: Array<string>;
  public vigenciaFim: Date;
  public vigenciaInicio: Date;

  constructor(values: Object) {
    super();
    Object.assign(this, values);
  }
}
