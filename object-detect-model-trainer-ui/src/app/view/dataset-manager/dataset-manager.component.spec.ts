import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatasetManagerComponent } from './dataset-manager.component';

describe('DatasetManagerComponent', () => {
  let component: DatasetManagerComponent;
  let fixture: ComponentFixture<DatasetManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DatasetManagerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DatasetManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
