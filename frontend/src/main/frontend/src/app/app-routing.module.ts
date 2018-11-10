import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ResultListComponent } from './result-list/result-list.component';

const routes: Routes = [
  { path: 'admin', component: AdminComponent },
  { path: '', component: ResultListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
