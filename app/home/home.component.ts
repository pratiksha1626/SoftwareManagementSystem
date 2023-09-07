import { Component } from '@angular/core';
//import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  showMoreInfo: boolean = false;

  toggleReadMore() {
    this.showMoreInfo = !this.showMoreInfo;
  }

  //  constructor(private router:Router) { }

  //  goToHome() {
  //    this.router.navigateByUrl('/');
  //  }

}
