import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateRoomdetailsComponent } from './update-roomdetails.component';

describe('UpdateRoomdetailsComponent', () => {
  let component: UpdateRoomdetailsComponent;
  let fixture: ComponentFixture<UpdateRoomdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateRoomdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateRoomdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
