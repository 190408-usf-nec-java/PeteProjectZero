import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SubmitTicketComponent } from './components/submit-ticket/submit-ticket.component';
import { RequestTicketComponent } from './components/request-ticket/request-ticket.component';
import { ViewTicketsComponent } from './components/view-tickets/view-tickets.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { ViewEmployeeComponent } from './components/view-employee/view-employee.component';
import { UpdateComponent } from './components/update/update.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SubmitTicketComponent,
    RequestTicketComponent,
    ViewTicketsComponent,
    HomePageComponent,
    LoginComponent,
    ViewEmployeeComponent,
    UpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
