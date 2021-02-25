import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionDetailsService } from '../transaction-details/transaction-details.service';
import { TransactionDetails } from '../transaction-details/TransactionDetails';


@Component({
  selector: 'app-update-transaction-details',
  templateUrl: './update-transaction-details.component.html',
  styleUrls: ['./update-transaction-details.component.css']
})
export class UpdateTransactionDetailsComponent implements OnInit {
  transactiondetails: TransactionDetails;
  transactionId: number;
  constructor(private transactionDetailsService:TransactionDetailsService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.transactiondetails = new TransactionDetails();
      this.transactionId = this.route.snapshot.params['transactionId'];
      this.transactionDetailsService.getTransactionDetail(this.transactionId)
        .subscribe(data => {
          console.log(data)
          this.transactiondetails = data;
        }, error => console.log(error));
  }
  updateTransactionDetails()
    {
      this.transactionDetailsService.updateTransactionDetails(this.transactiondetails)
      .subscribe(data => console.log(data), error => console.log(error))
      this.transactiondetails = new TransactionDetails();
      this.gotoList();
    }

    onSubmit() {
      this.updateTransactionDetails();    
    }
    
    gotoList()
    {
      this.router.navigate(['/transactiondetails']);
    }

}
