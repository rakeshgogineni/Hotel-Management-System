import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingDetails } from '../bookingdetails/BookingDetails';
import { BookingdetailsService } from '../bookingdetails/bookingdetails.service';

@Component({
  selector: 'app-create-booking-details',
  templateUrl: './create-booking-details.component.html',
  styleUrls: ['./create-booking-details.component.css']
})
export class CreateBookingDetailsComponent implements OnInit {

  bookingdetails: BookingDetails = new BookingDetails();
  constructor(private bookingdetailsService : BookingdetailsService,
    private router: Router) { }

  ngOnInit() {
  }

  save()
  {
    this.bookingdetailsService.createBookingDetails(this.bookingdetails)
    .subscribe(data => console.log(data), error => console.log(error));
    this.bookingdetails = new BookingDetails();
    this.goToList();
  }
  
  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/bookingdetails']);
  }

}
