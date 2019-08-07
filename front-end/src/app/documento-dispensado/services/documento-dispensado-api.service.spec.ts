import { TestBed } from '@angular/core/testing';

import { DocumentoDispensadoApiService } from './documento-dispensado-api.service';

describe('DocumentoDispensadoApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DocumentoDispensadoApiService = TestBed.get(DocumentoDispensadoApiService);
    expect(service).toBeTruthy();
  });
});
