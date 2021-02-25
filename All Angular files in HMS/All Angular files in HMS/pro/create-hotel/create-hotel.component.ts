import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hotel } from '../hotel/Hotel';
import { HotelService } from '../hotel/hotel.service';

@Component({
  selector: 'app-create-hotel',
  templateUrl: './create-hotel.component.html',
  styleUrls: ['./create-hotel.component.css']
})
export class CreateHotelComponent implements OnInit {
  hotel: Hotel = new Hotel();
  constructor(private hotelService : HotelService,
    private router: Router) { }

  ngOnInit() {
  }
  
  save()
  {
    this.hotelService.createHotel(this.hotel)
    .subscribe(data => console.log(data), error => console.log(error));
    this.hotel = new Hotel();
    this.goToList();
  }
  
  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/hotel']);
  }
}

