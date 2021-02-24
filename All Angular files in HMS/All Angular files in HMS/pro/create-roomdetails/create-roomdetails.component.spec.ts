import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateRoomdetailsComponent } from './create-roomdetails.component';

describe('CreateRoomdetailsComponent', () => {
  let component: CreateRoomdetailsComponent;
  let fixture: ComponentFixture<CreateRoomdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateRoomdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateRoomdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
