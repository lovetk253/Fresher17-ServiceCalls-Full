import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionsEditComponent } from './actions-edit.component';

describe('ActionsEditComponent', () => {
  let component: ActionsEditComponent;
  let fixture: ComponentFixture<ActionsEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActionsEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionsEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
