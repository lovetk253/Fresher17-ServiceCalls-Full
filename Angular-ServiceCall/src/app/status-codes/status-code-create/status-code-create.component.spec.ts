import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusCodeCreateComponent } from './status-code-create.component';

describe('StatusCodeCreateComponent', () => {
  let component: StatusCodeCreateComponent;
  let fixture: ComponentFixture<StatusCodeCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatusCodeCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatusCodeCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
