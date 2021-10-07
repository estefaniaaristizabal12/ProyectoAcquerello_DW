import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavegacionComponent } from './navegacion/navegacion.component';
import { CartaComponent } from './carta/carta.component';
import { ContactoComponent } from './contacto/contacto.component';
import { RegistrarseComponent } from './registrarse/registrarse.component';
import { IniciarSesionComponent } from './iniciar-sesion/iniciar-sesion.component';
import { NavegaciongeneralComponent } from './navegaciongeneral/navegaciongeneral.component';
import { InicioComponent } from './inicio/inicio.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'
import { AppRoutingModule } from './app.router';
import { CarroComprasComponent } from './carro-compras/carro-compras.component';
import { OrdenesComponent } from './ordenes/ordenes.component';
import { InfoPlatoComponent } from './info-plato/info-plato.component';
import { MiCuentaComponent } from './mi-cuenta/mi-cuenta.component';
import { PerfilAdminComponent } from './perfil-admin/perfil-admin.component';
import { ReporteVentasComponent } from './reporte-ventas/reporte-ventas.component';
import { AdministrarProductoComponent } from './administrar-producto/administrar-producto.component';
import { EditarProductoComponent } from './editar-producto/editar-producto.component';
import { AgregarProductoComponent } from './agregar-producto/agregar-producto.component';

@NgModule({
  declarations: [
    AppComponent,
    NavegacionComponent,
    CartaComponent,
    ContactoComponent,
    RegistrarseComponent,
    IniciarSesionComponent,
    NavegaciongeneralComponent,
    InicioComponent,
    CarroComprasComponent,
    OrdenesComponent,
    InfoPlatoComponent,
    MiCuentaComponent,
    PerfilAdminComponent,
    ReporteVentasComponent,
    AdministrarProductoComponent,
    EditarProductoComponent,
    AgregarProductoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule
    
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }