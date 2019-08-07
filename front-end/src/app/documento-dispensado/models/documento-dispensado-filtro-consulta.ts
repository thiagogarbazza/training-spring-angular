import { AbstractFiltroPaginado } from "@shared/models/abstract-filtro-paginado";

export class DocumentoDispensadoFiltroConsulta extends AbstractFiltroPaginado {

  public clientes: Array<string>
  public dataBaseFim: Date;
  public dataBaseInicio: Date;
  public documentos: Array<string>;
  public grupoDocumentos: Array<string>;
  public situacoes: Array<string>;
}
