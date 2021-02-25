import { Component, OnInit } from '@angular/core';
import { PersonalDetails } from './PersonalDetails';
import { PersonalDetailsService } from './personal-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {
  errorMsg: any;
  personaldetails : PersonalDetails[];

  constructor(private personaldetailsService:PersonalDetailsService, private router: Router) { }

  ngOnInit() {
    this.personaldetailsService.getPersonalDetails().subscribe(
      data => this.personaldetails = data,
      error => this.errorMsg = error
    );
  }
  
  updatePersonalDetails(guestId: number) {
    this.router.navigate(['/updatepersonaldetails', guestId]);
  }
  // onSubmit() {
  //   this.personaldetails;    
  // }

  deletePersonalDetails(guestId: number) {
    this.personaldetailsService.deletePersonalDetails(guestId).subscribe(
      (data) => {
        console.log(data);
        this.reloadData();
      },
      (error) => console.log(error)
    );
  }

  reloadData() {
    this.personaldetailsService.getPersonalDetails().subscribe(
      data => this.personaldetails = data,
      error => this.errorMsg = error
      );
  }
  // onSubmit() {
  //   this.updatePersonalDetails();    
  // }

}

