import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class HomepageService {

//We can put this here or on the actual component does not matter but need to have this and router 
  constructor(private httpClient: HttpClient) { }

}
