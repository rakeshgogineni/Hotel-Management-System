import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Wallet } from '../wallet/Wallet';
import { WalletService } from '../wallet/wallet.service';

@Component({
  selector: 'app-create-wallet',
  templateUrl: './create-wallet.component.html',
  styleUrls: ['./create-wallet.component.css']
})
export class CreateWalletComponent implements OnInit {


  wallet: Wallet = new Wallet();
  constructor(private walletService:WalletService,
    private router: Router) { }

  ngOnInit() {
  }
  save()
  {
    this.walletService.createWallet(this.wallet)
    .subscribe(data => console.log(data), error => console.log(error));
    this.wallet = new Wallet();
    this.goToList();
  }
  
  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/wallet']);
  }

}
