import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse  } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiUtils } from '@shared/utils/api-utils';
import { environment } from '@env/environment';


export const apiURL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class AbstractApiService {

  constructor(
    private http: HttpClient
  ) { }

  protected buscarRecurso<T>(caminhoUrl: string, parametros?: any): Observable<T> {
    const params = ApiUtils.removerUndefinedEmptyNull(parametros);

    return this.http.get<T>(apiURL + caminhoUrl, { params });
  }

  protected incluirRecurso<T>(caminhoUrl: string, resource?: any): Observable<T> {
    const body = ApiUtils.removerUndefinedEmptyNull(resource);

    return this.http.post<T>(apiURL + caminhoUrl, body);
  }

  protected alterarRecurso<T>(caminhoUrl: string, resource?: any): Observable<T> {
    const body = ApiUtils.removerUndefinedEmptyNull(resource);

    return this.http.put<T>(apiURL + caminhoUrl, body);
  }

  protected excluirRecurso<T>(caminhoUrl: string): Observable<T> {
    return this.http.delete<T>(apiURL + caminhoUrl);
  }

  protected pesquisarRecurso<T>(caminhoUrl: string, parametros: any): Observable<T> {
    const params = ApiUtils.removerUndefinedEmptyNull(parametros);

    return this.http.get<T>(apiURL + caminhoUrl, { params });
  }
}
