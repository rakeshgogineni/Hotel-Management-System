import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTransactionDetailsComponent } from './update-transaction-details.component';

describe('UpdateTransactionDetailsComponent', () => {
  let component: UpdateTransactionDetailsComponent;
  let fixture: ComponentFixture<UpdateTransactionDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateTransactionDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateTransactionDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
