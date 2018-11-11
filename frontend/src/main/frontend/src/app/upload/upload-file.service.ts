import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class UploadFileService {

  constructor(private http: HttpClient) {}

  pushFileToStorage(key,file: File): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();
    formdata.append('key', key);
    formdata.append('file', file);
    const req = new HttpRequest('POST', '/api/upload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }


}
