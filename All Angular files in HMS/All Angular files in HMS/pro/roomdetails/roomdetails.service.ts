import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Roomdetails } from './Roomdetails';

@Injectable({
  providedIn: 'root'
})
export class RoomdetailsService {

  private url = 'http://localhost:26930/MLP269/api/roomdetails';

  constructor(private httpClient: HttpClient) { }

  getRoomdetails() : Observable<Roomdetails[]>{
    return this.httpClient.get<Roomdetails[]>(`${this.url}`);
  }

  getRoomdetail(roomNo : number): Observable<any>
  {
      return this.httpClient.get(`${this.url}/${roomNo}`);
  }

  createRoomdetails(roomdetails: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, roomdetails);
  }

  updateRoomdetails(roomdetails: any): Observable<Object> {
    return this.httpClient.put(`${this.url}`, roomdetails);
  }
  deleteRoomdetails(roomNo: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${roomNo}`, { responseType: 'text' });
  }
}
