import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class GetBeneficioService {

  beneficio: any;

  constructor(private http: HttpClient) { }

  getBeneficio(id){
    return this.http.get('http://localhost:8080/beneficios/' + id)    
  }
}
