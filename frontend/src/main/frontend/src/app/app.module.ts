import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ResultListComponent } from './result-list/result-list.component';
import {DetailsUploadComponent} from './upload/details-upload/details-upload.component';
import {FormUploadComponent} from './upload/form-upload/form-upload.component';
import {UploadFileService} from './upload/upload-file.service';

import { HttpClientModule } from '@angular/common/http';
import { ResultCardComponent } from './result-card/result-card.component';
import { AppRoutingModule } from './app-routing.module';
import { AdminComponent } from './admin/admin.component';
import { enableProdMode } from '@angular/core';

@NgModule({
  declarations: [
    AppComponent,
    ResultListComponent,
    ResultCardComponent,
    AdminComponent,
    DetailsUploadComponent,
    FormUploadComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }

