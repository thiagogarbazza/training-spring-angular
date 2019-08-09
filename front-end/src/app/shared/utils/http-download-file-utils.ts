import { saveAs } from 'file-saver';
import { HttpResponse } from '@angular/common/http';


export class HttpDownloadFileUtils {

  public static salvar(){

  }

  public static save(blob:Blob, fileName: string){
    saveAs(blob, fileName);
  }

  public static extractFileName (res: HttpResponse<Blob>) {
    const contentDisposition = res.headers.get('content-disposition') || '';
    const matches = /filename=([^;]+)/ig.exec(contentDisposition);

    return (matches[1] || 'untitled').trim();
};
}
