import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingDetails } from '../bookingdetails/BookingDetails';
import { BookingdetailsService } from '../bookingdetails/bookingdetails.service';

@Component({
  selector: 'app-update-booking-details',
  templateUrl: './update-booking-details.component.html',
  styleUrls: ['./update-booking-details.component.css']
})
export class UpdateBookingDetailsComponent implements OnInit {
  bookingdetails: BookingDetails;
  bookingId: number;

  constructor(private bookingdetailsService : BookingdetailsService,
    private router: Router,private route: ActivatedRoute ) { }

  ngOnInit() {
  
    this.bookingdetails = new BookingDetails();
    this.bookingId = this.route.snapshot.params['bookingId'];
    this.bookingdetailsService.getBookingId(this.bookingId)
      .subscribe(data => {
        console.log(data)
        this.bookingId = data;
      }, error => console.log(error));
}
updateBookingDetails()
  {
    this.bookingdetailsService.updateBookingDetails(this.bookingdetails)
    .subscribe(data => console.log(data), error => console.log(error))
    this.bookingdetails = new BookingDetails();
    this.gotoList();
  }

  onSubmit() {
    this.updateBookingDetails();    
  }

  gotoList()
  {
    this.router.navigate(['/bookingdetails']);
  }



}
