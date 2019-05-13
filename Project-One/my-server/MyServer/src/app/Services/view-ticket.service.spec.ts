import { TestBed } from '@angular/core/testing';

import { ViewTicketService } from './view-ticket.service';

describe('ViewTicketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewTicketService = TestBed.get(ViewTicketService);
    expect(service).toBeTruthy();
  });
});
