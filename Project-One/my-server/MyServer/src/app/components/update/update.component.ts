import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';
import { UpdateService } from 'src/app/Services/update.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  splitCache = sessionStorage.getItem('cache').split(' ');
  name = this.splitCache[2] + ' ' + this.splitCache[3];
  UserId = this.splitCache[0];
  role_id = this.splitCache[4];

  reim_status_id=0;
  reim_id=0;

  updateArray;
  UpdateResponse: Subscription;
  lastStatus = 200;

  constructor(private updateTicketService: UpdateService, 
    private router: Router) { }

  ngOnInit() {}

  update(){
    console.log('update');
    this.updateTicketService.UpdateNew(this.reim_status_id,this.reim_id);
  }

  BacktoHome(){
    this.router.navigateByUrl('homepage');
  }

}
