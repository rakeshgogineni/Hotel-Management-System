import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { BookingDetails } from './BookingDetails';

@Injectable({
  providedIn: 'root'
})
export class BookingdetailsService {

private url = 'http://localhost:26930/MLP269/api/bookingdetails';
  constructor(private httpClient: HttpClient) { }

  getBookingDetails() : Observable<BookingDetails[]>{
    return this.httpClient.get<BookingDetails[]>(`${this.url}`);
  }
  getBookingId(bookingId:any): Observable<any>{
    return this.httpClient.get(`${this.url}/${bookingId}`);
  }
  createBookingDetails(bookingdetails: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, bookingdetails);
  }
  updateBookingDetails(bookingdetails:any): Observable<Object> {
    return this.httpClient.put(`${this.url}`, bookingdetails);
  }
  deleteHotel(bookingId: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${bookingId}`);
  }

}
