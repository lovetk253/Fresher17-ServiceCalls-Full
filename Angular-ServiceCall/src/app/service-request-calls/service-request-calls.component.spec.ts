import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceRequestCallsComponent } from './service-request-calls.component';

describe('ServiceRequestCallsComponent', () => {
  let component: ServiceRequestCallsComponent;
  let fixture: ComponentFixture<ServiceRequestCallsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceRequestCallsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceRequestCallsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
