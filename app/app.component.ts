import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from './authentication-service.service';
//import { AuthenticationService } from './authentication.service.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  router: any;
title(title: any) {
  throw new Error('Method not implemented.');
}

//    constructor(private router:Router){

//    }
  

  //   SoftwareList()
  // {
  //    this.router.navigate(['software-list'])
  //   }
  // ngOninit(){}

 constructor(public loginService:AuthenticationServiceService) { }

 }