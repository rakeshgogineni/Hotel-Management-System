import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionDetailsService } from './transaction-details.service';
import { TransactionDetails } from './TransactionDetails';

@Component({
  selector: 'app-transaction-details',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent implements OnInit {
errorMsg: any;
transactionDetails: TransactionDetails[];
  constructor(private transactionDetailsService:TransactionDetailsService,private router:Router) { }

  ngOnInit() {
    this.transactionDetailsService.getTransactionDetails().subscribe(
      data => this.transactionDetails = data,
      error => this.errorMsg = error
    );
  } 
  updateTransactionDetails(transactionId: number) {
    this.router.navigate(['/updatetransactiondetails', transactionId]);
  }
  deleteTransactionDetails(transactionId: number) {
    this.transactionDetailsService.deleteTransactionDetails(transactionId).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.transactionDetailsService.getTransactionDetails().subscribe(
      data => this.transactionDetails = data,
      error => this.errorMsg = error
      );
  }

  // OfferDetails(id: number) {
  //   console.log('id: ' + id);
  //   this.router.navigate(['/eGalaxy/Offers/details', id]);
  // }

/*   updateOffer(transactionId: number) {
   
  } */

}
