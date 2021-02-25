import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from '../hotel/Hotel';
import { HotelService } from '../hotel/hotel.service';

@Component({
  selector: 'app-update-hotel',
  templateUrl: './update-hotel.component.html',
  styleUrls: ['./update-hotel.component.css']
})
export class UpdateHotelComponent implements OnInit {
  hotel: Hotel;
  hotelName: any;

  constructor(private hotelService:HotelService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.hotel = new Hotel();
    this.hotelName = this.route.snapshot.params['hotelName'];
    this.hotelService.getHotelName(this.hotelName)
      .subscribe(data => {
        console.log(data)
        this.hotel = data;
      }, error => console.log(error));
}
updateHotel()
  {
    this.hotelService.updateHotel(this.hotel)
    .subscribe(data => console.log(data), error => console.log(error))
    this.hotel = new Hotel();
    this.gotoList();
  }

  onSubmit() {
    this.updateHotel();    
  }

  gotoList()
  {
    this.router.navigate(['/hotel']);
  }



}
