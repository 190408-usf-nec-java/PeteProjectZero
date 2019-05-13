import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SubmitTicketComponent } from './components/submit-ticket/submit-ticket.component';
import { ViewTicketsComponent } from './components/view-tickets/view-tickets.component';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { UpdateComponent } from './components/update/update.component';

const routes: Routes = [

{
  //This is for the root to be at the Logins Page
  path: '',
  component: LoginComponent
},

{
  path: 'homepage',
  component: HomePageComponent
},

{
  path: 'submit',
  component: SubmitTicketComponent
},

{
  path: 'view',
  component: ViewTicketsComponent
},

{
  path: 'viewall',
  component: ViewEmployeeComponent,
},

{
  path: 'Update',
  component: UpdateComponent
},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
