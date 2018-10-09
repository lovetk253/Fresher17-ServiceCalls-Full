import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusCodeEditComponent } from './status-code-edit.component';

describe('StatusCodeEditComponent', () => {
  let component: StatusCodeEditComponent;
  let fixture: ComponentFixture<StatusCodeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StatusCodeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StatusCodeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
