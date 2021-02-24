import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Roomdetails } from '../roomdetails/Roomdetails';
import { RoomdetailsService } from '../roomdetails/roomdetails.service';

@Component({
  selector: 'app-update-roomdetails',
  templateUrl: './update-roomdetails.component.html',
  styleUrls: ['./update-roomdetails.component.css']
})
export class UpdateRoomdetailsComponent implements OnInit {

  roomdetails: Roomdetails;
  roomNo: number;
  constructor(private roomdetailsService:RoomdetailsService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.roomdetails = new Roomdetails();
      this.roomNo = this.route.snapshot.params['roomNo'];
      this.roomdetailsService.getRoomdetail(this.roomNo)
        .subscribe(data => {
          console.log(data)
          this.roomdetails = data;
        }, error => console.log(error));
  }
  updateRoomdetails()
    {
      this.roomdetailsService.updateRoomdetails(this.roomdetails)
      .subscribe(data => console.log(data), error => console.log(error))
      this.roomdetails = new Roomdetails();
      this.gotoList();
    }

    onSubmit() {
      this.updateRoomdetails();    
    }

    gotoList()
    {
      this.router.navigate(['/roomdetails']);
    }

}
