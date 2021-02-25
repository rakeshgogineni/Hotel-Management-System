import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Offer } from '../offers/Offer';
import { OfferService } from '../offers/offer.service';

@Component({
  selector: 'app-update-offer',
  templateUrl: './update-offer.component.html',
  styleUrls: ['./update-offer.component.css']
})
export class UpdateOfferComponent implements OnInit {
  offer: Offer;
  offerId: number;
  constructor(private offerService:OfferService,private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.offer = new Offer();
      this.offerId = this.route.snapshot.params['offerId'];
      this.offerService.getOffer(this.offerId)
        .subscribe(data => {
          console.log(data)
          this.offer = data;
        }, error => console.log(error));
  }
  updateOffer()
    {
      this.offerService.updateOffer(this.offer)
      .subscribe(data => console.log(data), error => console.log(error))
      this.offer = new Offer();
      this.gotoList();
    }

    onSubmit() {
      this.updateOffer();    
    }

    gotoList()
    {
      this.router.navigate(['/offers']);
    }


  
}