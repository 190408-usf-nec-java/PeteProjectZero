import { Component, OnInit } from '@angular/core';
import { Reimbursements } from 'src/app/components/Classes/ErsReimb';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-employee',
  templateUrl: './view-employee.component.html',
  styleUrls: ['./view-employee.component.css']
})
export class ViewEmployeeComponent implements OnInit {

  reimbArray = new Array <Reimbursements>();

  constructor(private httpClient:HttpClient, private router: Router) { }

  ngOnInit() {
    this.viewReim();
  }

  viewReim():void{
    this.httpClient.get('http://localhost:8081/MyServer/requestAll', {
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

  updateReim( status_id: number, resolver: number, id: number):void{
    const payload ={
      status_Id:status_id,
      resolver : 1,
      id : id,
    };
    this.httpClient.put('http://localhost:8081/MyServer/submit', payload, {
      observe: 'response'
    }).subscribe(Response =>{

    },err =>{

    });
}

BacktoHome(){
  this.router.navigateByUrl('homepage');
}
}
