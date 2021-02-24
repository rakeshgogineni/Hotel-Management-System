import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTransactionDetailsComponent } from './create-transaction-details.component';

describe('CreateTransactionDetailsComponent', () => {
  let component: CreateTransactionDetailsComponent;
  let fixture: ComponentFixture<CreateTransactionDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateTransactionDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateTransactionDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
