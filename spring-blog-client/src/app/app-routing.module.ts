import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {OverviewComponent} from "./post/overview/overview.component";
import {DetailComponent} from "./post/detail/detail.component";
import {CreateComponent} from "./post/create/create.component";

const routes: Routes = [
  {path: '', component: OverviewComponent},
  {path: 'post/create', component: CreateComponent},
  {path: 'post/:id', component: DetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
