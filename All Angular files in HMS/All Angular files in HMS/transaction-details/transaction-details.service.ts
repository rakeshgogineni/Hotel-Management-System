import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransactionDetails } from './TransactionDetails';

@Injectable({
  providedIn: 'root'
})
export class TransactionDetailsService {

 private url = "http://localhost:26930/MLP269/api/transactiondetails";

  constructor(private httpClient: HttpClient) { }
  getTransactionDetails() :Observable<TransactionDetails[]>{
    return this.httpClient.get<TransactionDetails[]>(`${this.url}`);
  }
  getTransactionDetail(transactionId: number) :Observable<any>{
    return this.httpClient.get(`${this.url}/${transactionId}`);
  }
  createTransactionDetails(transactiondetails: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, transactiondetails);
  }
  updateTransactionDetails(transactiondetails: any): Observable<Object> {
    return this.httpClient.put(`${this.url}`, transactiondetails);
  }
  deleteTransactionDetails(transactionId: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${transactionId}`, { responseType: 'text' });
  }
}
