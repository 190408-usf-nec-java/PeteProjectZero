import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Reimbursements } from 'src/app/components/Classes/ErsReimb';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  private UpdateSubject = new Subject<number>();
  public $UpdateStatus = this.UpdateSubject.asObservable();

  updateArray = new Array <Reimbursements>();

  constructor(private httpClient: HttpClient) { }

  UpdateNew( reim_status_id: number, reim_id: number): void {const payload = {
      reim_status_id:reim_status_id,
      reim_id: reim_id,
    };

    this.httpClient.put('http://localhost:8081/MyServer/update', payload,{
    observe: 'response'
  }).subscribe(Response => {

  }, err => {

  });

}
}
