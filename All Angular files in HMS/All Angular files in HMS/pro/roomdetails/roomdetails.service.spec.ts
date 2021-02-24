import { TestBed } from '@angular/core/testing';

import { RoomdetailsService } from './roomdetails.service';

describe('RoomdetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RoomdetailsService = TestBed.get(RoomdetailsService);
    expect(service).toBeTruthy();
  });
});
