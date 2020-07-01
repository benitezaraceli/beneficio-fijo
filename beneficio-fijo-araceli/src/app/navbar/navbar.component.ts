import { Component, OnInit } from '@angular/core';
import { GetBeneficioService } from '../get-beneficio.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  beneficio: any;
  show = false;

  constructor(public getbeneficio: GetBeneficioService) { }
  
  ngOnInit(): void {
  }

  getBeneficio(id){
    this.getbeneficio.getBeneficio(id).subscribe(data => {      
      this.beneficio = data;
      this.show = true;
    });
    return this.beneficio;
  }
}
