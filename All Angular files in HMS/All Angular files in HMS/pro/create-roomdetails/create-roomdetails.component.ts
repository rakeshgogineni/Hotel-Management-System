import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Roomdetails } from '../roomdetails/Roomdetails';
import { RoomdetailsService } from '../roomdetails/roomdetails.service';

@Component({
  selector: 'app-create-roomdetails',
  templateUrl: './create-roomdetails.component.html',
  styleUrls: ['./create-roomdetails.component.css']
})
export class CreateRoomdetailsComponent implements OnInit {

roomdetails: Roomdetails = new Roomdetails();
  constructor(private roomdetailsService:RoomdetailsService,
    private router: Router) { }

  ngOnInit() {
  }

  save()
  {
    this.roomdetailsService.createRoomdetails(this.roomdetails)
    .subscribe(data => console.log(data), error => console.log(error));
    this.roomdetails = new Roomdetails();
    this.goToList();
  }
  
  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/roomdetails']);
  }

}
