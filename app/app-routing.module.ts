import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SoftwareListComponent } from './software-list/software-list.component';
import { CreateSoftwareComponent } from './create-software/create-software.component';
import { UpdateSoftwareComponent } from './update-software/update-software.component';
import { SoftwareDetailsComponent } from './software-details/software-details.component';
import { HomeComponent } from './home/home.component';

import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
import { AboutComponent } from './about/about.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';
 import { BuyNowComponent } from './buy-now/buy-now.component';



const routes: Routes = [
  {path: 'softwares', component: SoftwareListComponent ,canActivate:[AuthGaurdServiceService]},
  {path: 'create-software', component: CreateSoftwareComponent ,canActivate:[AuthGaurdServiceService]},
  // {path: '', redirectTo: 'Software', pathMatch: 'full', canActivate:[AuthGaurdServiceService]},
  {path: 'update-software/:softwareId', component: UpdateSoftwareComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'software-details/:softwareId', component: SoftwareDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'software-list', component: SoftwareListComponent,canActivate:[AuthGaurdServiceService]},
  {path :'home',component:HomeComponent,canActivate:[AuthGaurdServiceService]},

  {path :'contact',component:ContactComponent},
  {path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent ,canActivate:[AuthGaurdServiceService]},
 {path:'aboutus', component:AboutComponent},
 {path:'feedback', component:FeedbackComponent},
 {path: 'view-user/:softwareId',component:ViewCustomerComponent},
  {path:'buy-now/:softwareId',component:BuyNowComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }