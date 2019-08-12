export class DocumentoParaSelecaoResource {
  public codigo: string;
  public id: string;
  public nome: string;

  constructor(values: Object) {
    Object.assign(this, values);
  }
}
