import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpResponse, HttpEventType} from '@angular/common/http';
import {UploadFileService} from '../upload-file.service';

@Component({
  selector: 'form-upload',
  templateUrl: './form-upload.component.html',
  styleUrls: ['./form-upload.component.css']
})
export class FormUploadComponent implements OnInit {

  selectedFiles: FileList;
  currentFileUpload: File;
  target;
  key;
  progress: { percentage: number } = {percentage: 0};

  constructor(private uploadService: UploadFileService) {
    this.key = 'setme';
  }

  ngOnInit() {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
    this.target = event.target;
  }

  setKey(newKey) {
    this.key = newKey;
  }

  upload() {
    this.progress.percentage = 0;
    if ((this.selectedFiles !== undefined) && (this.selectedFiles.length > 0)) {
      this.currentFileUpload = this.selectedFiles.item(0);
      this.uploadService.pushFileToStorage(this.key,this.currentFileUpload).subscribe(event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress.percentage = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
      });
    }
  }
}
