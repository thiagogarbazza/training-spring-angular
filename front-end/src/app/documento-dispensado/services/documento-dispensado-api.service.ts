import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRouteSnapshot, RouterStateSnapshot, Resolve } from '@angular/router';
import { Observable } from 'rxjs';

import { AbstractApiService } from '@shared/services/abstract-api.service';
import { DocumentoDispensadoParaPesquisarResource } from '@app/documento-dispensado/models/documento-dispensado-para-pesquisar-resource';
import { DocumentoDispensadoFiltroConsulta } from '@app/documento-dispensado/models/documento-dispensado-filtro-consulta';

@Injectable({
  providedIn: 'root'
})
export class DocumentoDispensadoApiService extends AbstractApiService{

  constructor(
    http: HttpClient
  ) {
    super(http);
  }

  public paraPesquisar<DocumentoDispensadoParaPesquisarResource>(parametros: DocumentoDispensadoFiltroConsulta): Observable<DocumentoDispensadoParaPesquisarResource> {
    return super.buscarRecurso(`/documento-dispensado/para-pesquisar`, parametros);
  }
}

@Injectable({
  providedIn: 'root'
})
export class DocumentoDispensadoParaPesquisarResolver implements Resolve<DocumentoDispensadoParaPesquisarResource>{

  constructor(private documentoDispensadoApiService: DocumentoDispensadoApiService) { }

  public resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<DocumentoDispensadoParaPesquisarResource> {
    return this.documentoDispensadoApiService.paraPesquisar(route.queryParams as DocumentoDispensadoFiltroConsulta);
  }
}
