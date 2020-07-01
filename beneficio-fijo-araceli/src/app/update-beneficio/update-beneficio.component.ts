import { Component, OnInit } from '@angular/core';
import { GetBeneficioService } from '../get-beneficio.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from "@angular/router"

@Component({
  selector: 'app-update-beneficio',
  templateUrl: './update-beneficio.component.html',
  styleUrls: ['./update-beneficio.component.css']
})
export class UpdateBeneficioComponent implements OnInit {

  updateFormGroup(){
    return new FormGroup({
      nombre: new FormControl('', [Validators.required, Validators.minLength(1)]),
      descripcion: new FormControl('', Validators.maxLength(30)),
      campaña: new FormControl('', [Validators.required, Validators.minLength(5)]),
      codigoBeneficio: new FormControl('', [Validators.required, Validators.minLength(5)]),
      tipoBeneficio: new FormGroup({
        id: new FormControl(''),
        nombre: new FormControl(''),
      }),
      fechaExpiracion: new FormControl(''),
    });
  }
  
  private options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };
  updateForm: FormGroup;
  beneficio: any;
  response: any;
  id: Number;
  show = false;

  constructor(private http: HttpClient, public getbeneficio: GetBeneficioService, private router: Router) { }

  ngOnInit(): void {
    this.updateForm = this.updateFormGroup();
  }

  getBeneficio(id){
    this.id = id;
    this.getbeneficio.getBeneficio(id).subscribe(data => {
      this.show = true
      this.beneficio = data
  });
  return this.beneficio;
  }

  onResetForm() {
    this.updateForm.reset();
  }

  onSaveForm(){
    console.log(this.updateForm.controls['descripcion'].value);
    if(this.updateForm.get('nombre').value != ''){
      this.beneficio.nombre = this.updateForm.get('nombre').value;
    }
    if(this.updateForm.controls['descripcion'].value != ''){
      this.beneficio.descripcion = this.updateForm.get('descripcion').value;
    }
    if(this.updateForm.get('codigoBeneficio').value != ''){
      this.beneficio.codigoBeneficio = this.updateForm.get('codigoBeneficio').value;
    }
    if(this.updateForm.get('tipoBeneficio.id').value != ''){
      this.beneficio.tipoBeneficio.id = this.updateForm.get('tipoBeneficio.id').value;
    }
    if(this.updateForm.get('fechaExpiracion').value != ''){
      this.beneficio.fechaExpiracion = this.updateForm.get('fechaExpiracion').value;
    }
      this.http.put('http://localhost:8080/beneficios/'+ this.id, this.beneficio).toPromise().then(data => {
      this.response = data;
      if(confirm("Beneficio actualizado exitosamente\n¿Desea editar otro beneficio?")) {
        window.location.reload() 
      }else{
        this.router.navigate(['/listar-beneficios'])
      }
    })
  }
}
