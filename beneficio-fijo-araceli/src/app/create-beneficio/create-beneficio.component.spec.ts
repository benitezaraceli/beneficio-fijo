import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBeneficioComponent } from './create-beneficio.component';

describe('CreateBeneficioComponent', () => {
  let component: CreateBeneficioComponent;
  let fixture: ComponentFixture<CreateBeneficioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBeneficioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBeneficioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
