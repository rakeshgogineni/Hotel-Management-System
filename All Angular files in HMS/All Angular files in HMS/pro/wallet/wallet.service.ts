import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wallet } from './Wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {

  private url = 'http://localhost:26930/MLP269/api/walletdetails';

  constructor(private httpClient: HttpClient) { }
  
  getWallet() :Observable<Wallet[]>{
    return this.httpClient.get<Wallet[]>(`${this.url}`);
  }
  gettWallet(walletId : number): Observable<any>
  {
      return this.httpClient.get(`${this.url}/${walletId}`);
  }
  createWallet(wallet: Object): Observable<Object> {
    return this.httpClient.post(`${this.url}`, wallet);
  }
  
  updateWallet(wallet: any): Observable<Object> {
    return this.httpClient.put(`${this.url}`, wallet);
  }

  deleteWallet(walletId: number): Observable<any> {
    return this.httpClient.delete(`${this.url}/${walletId}`, { responseType: 'text' });
  }

}
