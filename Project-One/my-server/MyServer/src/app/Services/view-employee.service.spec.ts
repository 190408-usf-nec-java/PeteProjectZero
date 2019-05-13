import { TestBed } from '@angular/core/testing';

import { ViewEmployeeService } from './view-employee.service';

describe('ViewEmployeeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewEmployeeService = TestBed.get(ViewEmployeeService);
    expect(service).toBeTruthy();
  });
});
