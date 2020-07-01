import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteBeneficioComponent } from './delete-beneficio.component';

describe('DeleteBeneficioComponent', () => {
  let component: DeleteBeneficioComponent;
  let fixture: ComponentFixture<DeleteBeneficioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteBeneficioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteBeneficioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
