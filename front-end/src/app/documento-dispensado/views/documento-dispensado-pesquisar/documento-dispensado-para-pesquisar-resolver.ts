import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

import { DocumentoDispensadoFiltroConsulta } from '@app/documento-dispensado/models/documento-dispensado-filtro-consulta';
import { DocumentoDispensadoParaPesquisarResource } from '@app/documento-dispensado/models/documento-dispensado-para-pesquisar-resource';
import { DocumentoDispensadoApiService } from '@app/documento-dispensado/services/documento-dispensado-api.service';

@Injectable({
  providedIn: 'root'
})
export class DocumentoDispensadoParaPesquisarResolver implements Resolve<DocumentoDispensadoParaPesquisarResource>{

  constructor(private documentoDispensadoApiService: DocumentoDispensadoApiService) { }

  public resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<DocumentoDispensadoParaPesquisarResource> {
    return this.documentoDispensadoApiService.paraPesquisar(route.queryParams as DocumentoDispensadoFiltroConsulta);
  }
}
