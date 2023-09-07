import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { NgxPaginationModule } from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateSoftwareComponent } from './create-software/create-software.component';
import { SoftwareDetailsComponent } from './software-details/software-details.component';
import { SoftwareListComponent } from './software-list/software-list.component';
import { UpdateSoftwareComponent } from './update-software/update-software.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HttpClientJsonpModule, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { BuyNowComponent } from './buy-now/buy-now.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateSoftwareComponent,
    SoftwareDetailsComponent,
    SoftwareListComponent,
    UpdateSoftwareComponent,
    LoginComponent,
    LogoutComponent,
    AboutComponent,
    ContactComponent,
    HomeComponent,
    FeedbackComponent,
    BuyNowComponent,
    ViewCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
