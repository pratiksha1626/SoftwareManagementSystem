import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSoftwareComponent } from './create-software.component';

describe('CreateSoftwareComponent', () => {
  let component: CreateSoftwareComponent;
  let fixture: ComponentFixture<CreateSoftwareComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateSoftwareComponent]
    });
    fixture = TestBed.createComponent(CreateSoftwareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
