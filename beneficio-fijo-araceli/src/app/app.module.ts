import { RouterModule , Routes } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ListBeneficiosComponent } from './list-beneficios/list-beneficios.component';
import { CreateBeneficioComponent } from './create-beneficio/create-beneficio.component';
import { UpdateBeneficioComponent } from './update-beneficio/update-beneficio.component';
import { DeleteBeneficioComponent } from './delete-beneficio/delete-beneficio.component';

import { GetBeneficioService } from './get-beneficio.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

const rutasApp:Routes = [
  {path:'listar-beneficios', component: ListBeneficiosComponent},
  {path:'crear-beneficio', component: CreateBeneficioComponent},
  {path:'borrar-beneficio', component: DeleteBeneficioComponent},
  {path:'actualizar-beneficio', component: UpdateBeneficioComponent},
  {path:'**', redirectTo: ''}
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListBeneficiosComponent,
    CreateBeneficioComponent,
    UpdateBeneficioComponent,
    DeleteBeneficioComponent
  ],
  imports: [
    RouterModule.forRoot(rutasApp),
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [
    GetBeneficioService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
