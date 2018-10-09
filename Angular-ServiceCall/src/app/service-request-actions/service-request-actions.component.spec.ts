import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceRequestActionsComponent } from './service-request-actions.component';

describe('ServiceRequestActionsComponent', () => {
  let component: ServiceRequestActionsComponent;
  let fixture: ComponentFixture<ServiceRequestActionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceRequestActionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceRequestActionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
