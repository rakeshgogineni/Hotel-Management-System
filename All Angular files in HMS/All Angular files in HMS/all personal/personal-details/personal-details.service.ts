import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonalDetails } from './PersonalDetails';

@Injectable({
  providedIn: 'root'
})
export class PersonalDetailsService {
  
  private url = 'http://localhost:26930/MLP269/api/personaldetails';

  constructor(private httpClient: HttpClient) { }

  getPersonalDetails() : Observable<PersonalDetails[]>{
    //  let url = "http://localhost:26930/MLP269/api/personaldetails";
     return this.httpClient.get<PersonalDetails[]>(`${this.url}`);
  }
  getPersonalDetail(guestId : number): Observable<any>
  {
      return this.httpClient.get(`${this.url}/${guestId}`);
  }
  createPersonalDetails(personaldetails: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, personaldetails);
  }
  //updatePersonalDetails(guestId: number, address: any, phoneNo: any): Observable<Object> {
    updatePersonalDetails(personaldetails: any): Observable<Object> {
    return this.httpClient.put(`${this.url}`,personaldetails);
  }
  deletePersonalDetails(guestId: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${guestId}`, { responseType: 'text' });
  }
}
