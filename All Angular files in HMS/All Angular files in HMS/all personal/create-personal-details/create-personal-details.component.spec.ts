import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePersonalDetailsComponent } from './create-personal-details.component';

describe('CreatePersonalDetailsComponent', () => {
  let component: CreatePersonalDetailsComponent;
  let fixture: ComponentFixture<CreatePersonalDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatePersonalDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePersonalDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
