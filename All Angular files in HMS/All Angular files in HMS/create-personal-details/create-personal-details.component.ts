import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PersonalDetailsService } from '../personal-details/personal-details.service';
import { PersonalDetails } from '../personal-details/PersonalDetails';

@Component({
  selector: 'app-create-personal-details',
  templateUrl: './create-personal-details.component.html',
  styleUrls: ['./create-personal-details.component.css']
})
export class CreatePersonalDetailsComponent implements OnInit {

personaldetails: PersonalDetails = new PersonalDetails();
  constructor(private personaldetailsService:PersonalDetailsService,
    private router: Router) { }
 

  ngOnInit() {
  }

  save()
  {
    this.personaldetailsService.createPersonalDetails(this.personaldetails)
    .subscribe(data => console.log(data), error => console.log(error));
    this.personaldetails = new PersonalDetails();
    this.goToList();
  }

  onSubmit()
  {
    // this.submitted = true;
    this.save();  
  }

  goToList(){
    this.router.navigate(['/personaldetails']);
  }
  

}
