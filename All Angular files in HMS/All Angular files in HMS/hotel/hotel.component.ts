import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from './Hotel';
import { HotelService } from './hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {
  errorMsg: any;
  hotel : Hotel[];
  constructor(private hotelService:HotelService, private router:Router) { }

  ngOnInit() {
    this.hotelService.getHotel().subscribe(
      data => this.hotel = data,
      error => this.errorMsg = error
    );
  }

  deleteHotel(hotelId: number) {
    this.hotelService.deleteHotel(hotelId).subscribe(
      (data) => {
        console.log(data);
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.hotelService.getHotel().subscribe(
      data => this.hotel = data,
      error => this.errorMsg = error
    );
  }

  updateHotel(hotelName: any) {
      this.router.navigate(['/updateHotel', hotelName]);
  }
}
