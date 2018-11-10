import { Component, OnInit } from '@angular/core';
import {DetailsUploadComponent} from '../upload/details-upload/details-upload.component';
import {FormUploadComponent} from '../upload/form-upload/form-upload.component';
import {UploadFileService} from '../upload/upload-file.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})


export class AdminComponent implements OnInit {

  constructor(private http: HttpClient) {}

  ngOnInit() {
  }

  resetData() {
    console.log('calling reset');
    this.http.get('/api/reset').subscribe(data => (console.log(data)));
  }

}
