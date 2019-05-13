import { TestBed } from '@angular/core/testing';

import { SubmitTicketService } from './submit-ticket.service';

describe('SubmitTicketService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SubmitTicketService = TestBed.get(SubmitTicketService);
    expect(service).toBeTruthy();
  });
});
