import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionDetailsService } from '../transaction-details/transaction-details.service';
import { TransactionDetails } from '../transaction-details/TransactionDetails';

@Component({
  selector: 'app-create-transaction-details',
  templateUrl: './create-transaction-details.component.html',
  styleUrls: ['./create-transaction-details.component.css']
})
export class CreateTransactionDetailsComponent implements OnInit {


  transactiondetails: TransactionDetails = new TransactionDetails();
  constructor(private transactiondetailsService:TransactionDetailsService,
    private router: Router) { }

  ngOnInit() {
  }

  save()
  {
    this.transactiondetailsService.createTransactionDetails(this.transactiondetails)
    .subscribe(data => console.log(data), error => console.log(error));
    this.transactiondetails = new TransactionDetails();
    this.goToList();
  }
  
  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/transactiondetails']);
  }

}
