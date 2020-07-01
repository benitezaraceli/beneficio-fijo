import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import {Router} from "@angular/router"

@Component({
  selector: 'app-create-beneficio',
  templateUrl: './create-beneficio.component.html',
  styleUrls: ['./create-beneficio.component.css']
})
export class CreateBeneficioComponent implements OnInit {

  createFormGroup(){
    return new FormGroup({
      nombre: new FormControl(''),
      descripcion: new FormControl(''),
      campaña: new FormControl(''),
      codigoBeneficio: new FormControl(''),
      tipoBeneficio: new FormGroup({
        id: new FormControl(''),
        nombre: new FormControl(''),
      }),
      fechaExpiracion: new FormControl(''),
      fechaAlta: new FormControl(new Date())
    });
  }

  createForm: FormGroup;
  response: any;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.createForm = this.createFormGroup();
  }

  onResetForm() {
    this.createForm.reset();
  }

  onSaveForm(){
    if(this.createForm.get('tipoBeneficio.id').value == "1"){
      this.createForm.get('tipoBeneficio.nombre').setValue('activos');
    }else if(this.createForm.get('tipoBeneficio.id').value == "2"){
      this.createForm.get('tipoBeneficio.nombre').setValue('pausado');
    }else{      
      this.createForm.get('tipoBeneficio.nombre').setValue('cancelado');
    }
    
    if(this.createForm.valid){
      this.http.post('http://localhost:8080/beneficios/', this.createForm.value).toPromise().then(data => {
      this.response = data;
      if(confirm("Beneficio generado exitosamente\n¿Desea crear otro beneficio?")) {
        window.location.reload() 
      }else{
        this.router.navigate(['/listar-beneficios'])
      }
    })
    }else{
      alert("Complete los campos");
    }
  }
}
