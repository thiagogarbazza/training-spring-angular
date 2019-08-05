import { TestBed } from '@angular/core/testing';

import { AbstractApiService } from './abstract-api.service';

describe('AbstractApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AbstractApiService = TestBed.get(AbstractApiService);
    expect(service).toBeTruthy();
  });
});
