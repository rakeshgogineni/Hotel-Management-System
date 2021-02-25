import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hotel } from './Hotel';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  private url = 'http://localhost:26930/MLP269/api/hotel';

  constructor(private httpClient: HttpClient) { }

  getHotel(): Observable<Hotel[]> {
    return this.httpClient.get<Hotel[]>(`${this.url}`);
  }
  getHotelName(hotelName:any): Observable<any>{
    return this.httpClient.get(`${this.url}/${hotelName}`);
  }
  createHotel(hotel: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, hotel);
  }
  updateHotel(hotel: any): Observable<Object> {
    return this.httpClient.put(`${this.url}`, hotel);
  }
  deleteHotel(hotelId: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${hotelId}`);
  }

}
