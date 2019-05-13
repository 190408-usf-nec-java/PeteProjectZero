import { Component, OnInit } from '@angular/core';
import { HomepageService } from 'src/app/Services/homepage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  //Splitting the cache created in java 
  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  UserId = this.splitCache[0];
  role_id = this.splitCache[4];

//In the service there is the Http Connection and here we have to make a private router for routing to other components
  constructor(private homepageService: HomepageService, private router: Router) { }

  ngOnInit() {
  }

  managerValid(): boolean {
    return this.role_id === '1';
  }

  clearStorage(){
    sessionStorage.removeItem('cache');
  }

  SubmitTicket(){
    this.router.navigateByUrl('submit');
  }
  ViewTicket(){
    this.router.navigateByUrl('view');
  }
  ViewAll(){
    this.router.navigateByUrl('viewall');
  }


}
