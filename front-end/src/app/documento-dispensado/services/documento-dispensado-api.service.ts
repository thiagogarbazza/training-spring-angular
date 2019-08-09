import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AbstractApiService } from 'shared/services/abstract-api.service';
import { DocumentoDispensadoFiltroConsulta } from '@app/documento-dispensado/models/documento-dispensado-filtro-consulta';
import { CustomPageResource } from '@shared/models/custom-page-resource';
import { DocumentoDispensadoResultadoPesquisaResource } from '../models/documento-dispensado-resultado-pesquisa-resource';

@Injectable({
  providedIn: 'root'
})
export class DocumentoDispensadoApiService extends AbstractApiService{

  constructor(
    http: HttpClient,
    activatedRoute: ActivatedRoute,
    router: Router
  ) {
    super(http, activatedRoute, router);
  }

  public gerarRelatorioExcel(parametros: DocumentoDispensadoFiltroConsulta) : Observable<any> {
    return super.baixarArquivo(`/documento-dispensado/gerar-relatorio-excel`, parametros);
  }

  public paraPesquisar<DocumentoDispensadoParaPesquisarResource>(parametros: DocumentoDispensadoFiltroConsulta): Observable<DocumentoDispensadoParaPesquisarResource> {
    return super.buscarRecurso(`/documento-dispensado/para-pesquisar`, parametros);
  }

  public pesquisar(parametros: DocumentoDispensadoFiltroConsulta): Observable<CustomPageResource<DocumentoDispensadoResultadoPesquisaResource>> {
    return super.pesquisarRecurso(`/documento-dispensado/pesquisar`, parametros);
  }
}
