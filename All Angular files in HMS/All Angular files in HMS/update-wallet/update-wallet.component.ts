import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Wallet } from '../wallet/Wallet';
import { WalletService } from '../wallet/wallet.service';

@Component({
  selector: 'app-update-wallet',
  templateUrl: './update-wallet.component.html',
  styleUrls: ['./update-wallet.component.css']
})
export class UpdateWalletComponent implements OnInit {

  wallet: Wallet;
  walletId: number;
  constructor(private walletService:WalletService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.wallet = new Wallet();
      this.walletId = this.route.snapshot.params['walletId'];
      this.walletService.gettWallet(this.walletId)
        .subscribe(data => {
          console.log(data)
          this.wallet = data;
        }, error => console.log(error));
  }
  updateWallet()
    {
      this.walletService.updateWallet(this.wallet)
      .subscribe(data => console.log(data), error => console.log(error))
      this.wallet = new Wallet();
      this.gotoList();
    }

    onSubmit() {
      this.updateWallet();    
    }

    gotoList()
    {
      this.router.navigate(['/wallet']);
    }

 
}
