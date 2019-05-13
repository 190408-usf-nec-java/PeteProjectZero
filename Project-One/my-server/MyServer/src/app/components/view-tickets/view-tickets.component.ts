import { Component, OnInit } from '@angular/core';
import { Reimbursements } from 'src/app/components/Classes/ErsReimb';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';


@Component({
  selector: 'app-view-tickets',
  templateUrl: './view-tickets.component.html',
  styleUrls: ['./view-tickets.component.css']
})
export class ViewTicketsComponent implements OnInit {
  
  reimbArray = new Array <Reimbursements>();
  
  constructor(private httpClient:HttpClient, private router:Router) { }
  
  ngOnInit() {
    this.viewReim();
  }

  viewReim():void{
    this.httpClient.get('http://localhost:8081/MyServer/request', {
      observe: 'response'
    }).pipe(map(response => response.body as Array <Reimbursements>))
    .subscribe(response => {
      //this.viewReimbStatusSubject.next(200);
      response.forEach(element => {
        this.reimbArray.push(element);
      })
      }, err => {
        //this.viewReimbStatusSubject.next(err.status);
      });
}
BacktoHome(){
  this.router.navigateByUrl('homepage');
}
}

