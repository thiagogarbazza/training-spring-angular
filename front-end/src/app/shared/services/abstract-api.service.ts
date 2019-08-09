import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';

import { ApiUtils } from '@shared/utils/api-utils';
import { environment } from '@env/environment';
import { HttpDownloadFileUtils } from '@shared/utils/http-download-file-utils';



export const apiURL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class AbstractApiService {

  constructor(
    private http: HttpClient,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  protected baixarArquivo(caminhoUrl: string, parametros: any): Observable<any> {
    const params = ApiUtils.removerUndefinedEmptyNull(parametros);

    const type = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';

    this.http.get(apiURL + caminhoUrl, { headers: new HttpHeaders({
      'Content-Type': type,
      }), observe: 'response', responseType: 'blob', params: params})
      .subscribe((data) => {
        const fileName = HttpDownloadFileUtils.extractFileName(data);
        HttpDownloadFileUtils.save(data.body as Blob, fileName);
      },
      error => console.log(error));

    return of();
  }

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
    this.updateURLComParametrosDePesquisa(params);

    return this.http.get<T>(apiURL + caminhoUrl, { params });
  }

  private updateURLComParametrosDePesquisa(parametros: any) {
    this.router.navigate([], { relativeTo: this.activatedRoute, queryParams: parametros });
  }
}
