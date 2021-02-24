import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wallet } from './Wallet';
import { WalletService } from './wallet.service';

@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {
errorMsg: any;
wallet : Wallet[];
  constructor(private walletService:WalletService,private router: Router) { }

  ngOnInit() {
    this.walletService.getWallet().subscribe(
      data => this.wallet = data,
      error => this.errorMsg = error
    );
  }

  updateWallet(walletId: number) {
    this.router.navigate(['/updatewallet', walletId]);
  }

  deleteWallet(walletId: number) {
    this.walletService.deleteWallet(walletId).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.walletService.getWallet().subscribe(
      data => this.wallet = data,
      error => this.errorMsg = error
      );
  }

  // OfferDetails(id: number) {
  //   console.log('id: ' + id);
  //   this.router.navigate(['/eGalaxy/Offers/details', id]);
  // }

  /* updateOffer(walletId: number) {
   
  } */

}
