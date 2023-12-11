import { TestBed } from '@angular/core/testing';

import { ModelManagerClientService } from './model-manager-client.service';

describe('ModelManagerClientService', () => {
  let service: ModelManagerClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModelManagerClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
