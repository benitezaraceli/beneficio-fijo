import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateBeneficioComponent } from './update-beneficio.component';

describe('UpdateBeneficioComponent', () => {
  let component: UpdateBeneficioComponent;
  let fixture: ComponentFixture<UpdateBeneficioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateBeneficioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateBeneficioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
