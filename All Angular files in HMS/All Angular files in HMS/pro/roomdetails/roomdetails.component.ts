import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Roomdetails } from './Roomdetails';
import { RoomdetailsService } from './roomdetails.service';

@Component({
  selector: 'app-roomdetails',
  templateUrl: './roomdetails.component.html',
  styleUrls: ['./roomdetails.component.css']
})
export class RoomdetailsComponent implements OnInit {
  errorMsg: any;
  roomdetails : Roomdetails[];
  constructor(private roomdetailsService:RoomdetailsService, private router:Router) { }

  ngOnInit() {
    this.roomdetailsService.getRoomdetails().subscribe(
      data => this.roomdetails =data,
      error => this.errorMsg =error
    );
  }

  updateroomdetails(roomNo: number) {
    this.router.navigate(['/updateroomdetails', roomNo]);
  }

  deleteRoomdetails(roomNo: number) {
    this.roomdetailsService.deleteRoomdetails(roomNo).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.roomdetailsService.getRoomdetails().subscribe(
      data => this.roomdetails = data,
      error => this.errorMsg = error
      );
  }
}
