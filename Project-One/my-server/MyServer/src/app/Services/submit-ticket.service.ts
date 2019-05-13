import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Reimbursements } from 'src/app/components/Classes/ErsReimb';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SubmitTicketService {
  private SubmitSubject = new Subject<number>();
  public $SubmitStatus = this.SubmitSubject.asObservable();

  submitArray = new Array <Reimbursements>();

  constructor(private httpClient: HttpClient) { }

  SubmitNew( amount: number, description: string, 
  type_id: number): void {const payload = {
    amount:amount,
    description:description,
    type_Id:type_id,
    resolver: 1,
  };
  this.httpClient.post('http://localhost:8081/MyServer/submit', payload,{
    observe: 'response'
  }).subscribe(Response => {

  }, err => {

  });

}

  }