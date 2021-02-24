import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingDetails } from './BookingDetails';
import { BookingdetailsService } from './bookingdetails.service';

@Component({
  selector: 'app-bookingdetails',
  templateUrl: './bookingdetails.component.html',
  styleUrls: ['./bookingdetails.component.css']
})
export class BookingdetailsComponent implements OnInit {
  errorMsg: any;
  bookingdetails : BookingDetails[];
  constructor(private bookingdetailsService:BookingdetailsService, private router:Router) { }

  ngOnInit() {
    this.bookingdetailsService.getBookingDetails().subscribe(
      data => this.bookingdetails = data,
      error => this.errorMsg = error
    );
  }

  deleteBookingDetails(bookingId: number) {
    this.bookingdetailsService.deleteHotel(bookingId).subscribe(
      (data) => {
        console.log(data);
        //this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.bookingdetailsService.getBookingDetails().subscribe(
      data => this.bookingdetails = data,
      error => this.errorMsg = error
    );
  }
  updateBookingDetails(bookingId: number) {
    this.router.navigate(['/updateBookingDetails', bookingId]);
  }

}
