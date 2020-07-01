import { TestBed } from '@angular/core/testing';

import { GetBeneficioService } from './get-beneficio.service';

describe('GetBeneficioService', () => {
  let service: GetBeneficioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetBeneficioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
