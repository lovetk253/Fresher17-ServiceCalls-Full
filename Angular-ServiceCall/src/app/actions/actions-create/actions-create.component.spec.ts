import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionsCreateComponent } from './actions-create.component';

describe('ActionsCreateComponent', () => {
  let component: ActionsCreateComponent;
  let fixture: ComponentFixture<ActionsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActionsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
