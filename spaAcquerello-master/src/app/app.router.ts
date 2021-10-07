//Aca manejamos las rutas

import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { AdminGuard } from "./admin.guard";
import { AdministrarProductoComponent } from "./administrar-producto/administrar-producto.component";
import { AgregarProductoComponent } from "./agregar-producto/agregar-producto.component";
import { CarroComprasComponent } from "./carro-compras/carro-compras.component";
import { CartaComponent } from "./carta/carta.component";
import { ContactoComponent } from "./contacto/contacto.component";
import { EditarProductoComponent } from "./editar-producto/editar-producto.component";
import { InfoPlatoComponent } from "./info-plato/info-plato.component";
import { IniciarSesionComponent } from "./iniciar-sesion/iniciar-sesion.component";
import { IniciarGuard } from "./iniciar.guard";
import { InicioComponent } from "./inicio/inicio.component";
import { MiCuentaComponent } from "./mi-cuenta/mi-cuenta.component";
import { NavegacionComponent } from "./navegacion/navegacion.component";
import { OrdenesComponent } from "./ordenes/ordenes.component";
import { PerfilAdminComponent } from "./perfil-admin/perfil-admin.component";
import { RegistrarseComponent } from "./registrarse/registrarse.component";
import { ReporteVentasComponent } from "./reporte-ventas/reporte-ventas.component";

const routes = [
    {path: '', component:InicioComponent},
    {path: 'carta', component:CartaComponent},
    {path: 'contacto', component: ContactoComponent},
    {path: 'iniciarSesion', component: IniciarSesionComponent},
    {path: 'registrarse', component: RegistrarseComponent},
    {path: 'ordenes', component: OrdenesComponent,canActivate: [IniciarGuard]},
    {path: 'carroCompras', component: CarroComprasComponent,canActivate: [IniciarGuard]},
    {path: 'infoPlato', component: InfoPlatoComponent},
    {path: 'miCuenta', component: MiCuentaComponent, canActivate: [IniciarGuard]},
    {path: 'perfilAdmin', component: PerfilAdminComponent,canActivate: [AdminGuard]},
    {path: 'reporteVenta', component: ReporteVentasComponent,canActivate: [AdminGuard]},
    {path: 'administrarProductos', component: AdministrarProductoComponent,canActivate: [AdminGuard]},
    {path: 'editarProducto', component: EditarProductoComponent,canActivate: [AdminGuard]},
    {path: 'agregarProducto', component: AgregarProductoComponent,canActivate: [AdminGuard]}
    
];
@NgModule({
    imports:
    [
        RouterModule.forRoot(routes)
    ], 
    exports:[
        RouterModule

    ]
})
export class AppRoutingModule{

}