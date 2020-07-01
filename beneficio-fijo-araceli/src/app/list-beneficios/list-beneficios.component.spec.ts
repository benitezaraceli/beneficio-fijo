import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListBeneficiosComponent } from './list-beneficios.component';

describe('ListBeneficiosComponent', () => {
  let component: ListBeneficiosComponent;
  let fixture: ComponentFixture<ListBeneficiosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListBeneficiosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListBeneficiosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
