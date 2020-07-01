import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list-beneficios',
  templateUrl: './list-beneficios.component.html',
  styleUrls: ['./list-beneficios.component.css']
})
export class ListBeneficiosComponent implements OnInit {

  beneficios = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.listBeneficios();
  }

  listBeneficios(){
    this.http.get('http://localhost:8080/beneficios').toPromise().then(data => {
      for (let key in data){
        if (data.hasOwnProperty(key))
          this.beneficios.push(data[key])
      }
    });
  }
}