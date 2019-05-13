import { Injectable, OnInit } from '@angular/core';
import { Reimbursements } from '../components/Classes/ErsReimb';
import { Subscription, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ViewTicketService {
  private ViewSubject = new Subject<number>();
  public $ViewStatus = this.ViewSubject.asObservable();

  viewArray = new Array <Reimbursements>();
  
  constructor(private httpClient: HttpClient) { }

   View(): void {
    this.httpClient.get('http://localhost:8081/MyServer/RequestAll', 
    {observe: 'response'}).pipe(map(response => response.body as Array <Reimbursements>))
    .subscribe(response => {
      this.ViewSubject.next(200);
      response.forEach(element => {
        this.viewArray.push(element);
      })
    }, err => {
      this.ViewSubject.next(err.status);
    });
  }
}
