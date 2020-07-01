import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from '@angular/common/http';
import { GetBeneficioService } from '../get-beneficio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-delete-beneficio',
  templateUrl: './delete-beneficio.component.html',
  styleUrls: ['./delete-beneficio.component.css'],
})
export class DeleteBeneficioComponent implements OnInit {
  
  response = <any>{};
  id: Number;
  beneficio: any;
  deleteModal = false;

  constructor(private http: HttpClient, public getbeneficio: GetBeneficioService, private modalService: NgbModal, private router: Router) { }

  ngOnInit(): void {
  }

  getBeneficio(id){
      this.getbeneficio.getBeneficio(id).subscribe(data => {
      this.beneficio = data
    });
    return this.beneficio;
  }

  openModal(modal){
    this.modalService.open(modal);
  }

  closeModal(modal){
    this.modalService.dismissAll(modal);
  }

  deleteBeneficio(id, modal){
    this.http.delete('http://localhost:8080/beneficios/'+ id).toPromise().then(data => {
      this.response = data;
      this.closeModal(modal);
      if(!confirm("Beneficio borrado exitosamente\n¿Desea eliminar otro beneficio?")) {
        this.router.navigate(['/listar-beneficios'])
      }
    })
  }
}