import { TestBed } from '@angular/core/testing';

import { RequestTicketService } from './request-ticket.service';

describe('RequestTicketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RequestTicketService = TestBed.get(RequestTicketService);
    expect(service).toBeTruthy();
  });
});
