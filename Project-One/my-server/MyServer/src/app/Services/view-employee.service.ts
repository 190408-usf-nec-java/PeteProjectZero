import { Injectable, OnInit } from '@angular/core';
import { Reimbursements } from '../components/Classes/ErsReimb';
import { Subscription, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ViewEmployeeService {
  private ViewSubject = new Subject<number>();
  public $ViewStatus = this.ViewSubject.asObservable();
  
  viewArray = new Array <Reimbursements>();
  
  constructor(private httpClient: HttpClient) { }

}
