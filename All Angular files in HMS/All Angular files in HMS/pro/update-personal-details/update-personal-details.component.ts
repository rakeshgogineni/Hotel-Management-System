import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonalDetailsService } from '../personal-details/personal-details.service';
import { PersonalDetails } from '../personal-details/PersonalDetails';

@Component({
  selector: 'app-update-personal-details',
  templateUrl: './update-personal-details.component.html',
  styleUrls: ['./update-personal-details.component.css']
})
export class UpdatePersonalDetailsComponent implements OnInit {
  personaldetails: PersonalDetails;
  guestId: number;
  address: string;
  phoneNo: any;
  constructor(private personaldetailsService:PersonalDetailsService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.personaldetails = new PersonalDetails();
      this.guestId = this.route.snapshot.params['guestId'];
      this.personaldetailsService.getPersonalDetail(this.guestId)
        .subscribe(data => {
          console.log(data)
          this.personaldetails = data;
        }, error => console.log(error));
  }

  updatePersonalDetails()
    {
      this.personaldetailsService.updatePersonalDetails(this.personaldetails)
      .subscribe(data => console.log(data), error => console.log(error))
      this.personaldetails = new PersonalDetails();
      this.gotoList();
    }

    onSubmit() {
      this.updatePersonalDetails();    
    }

    gotoList()
    {
      this.router.navigate(['/personaldetails']);
    }
}
