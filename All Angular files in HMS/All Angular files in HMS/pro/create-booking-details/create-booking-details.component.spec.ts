import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBookingDetailsComponent } from './create-booking-details.component';

describe('CreateBookingDetailsComponent', () => {
  let component: CreateBookingDetailsComponent;
  let fixture: ComponentFixture<CreateBookingDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBookingDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBookingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
