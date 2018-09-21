/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import actionforms.ActionFormVentas;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.ClienteMantenimiento;
import mantenimientos.MantenimientoUsuario;
import mantenimientos.ProductosMantenimiento;
import mantenimientos.SucursalesMantenimiento;
import mantenimientos.VentasMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencias.Clientes;
import persistencias.Productos;
import persistencias.Sucursales;
import persistencias.Usuario;
import persistencias.Ventas;


public class ActionVentas extends org.apache.struts.action.Action {

    private static final String agregarVEN = "agregarVEN";
    private static final String consultarVEN = "consultarVEN";
    private static final String consultarIdVEN = "consultarIdVEN";
    private static final String modificarVEN = "modificarVEN";
    private static final String borrarVEN = "borrarVEN";
    private static final String eliminarVEN = "eliminarVEN";
    private static final String errorVEN = "errorVEN";
    private static final String irFormVenta = "irFormVenta";
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy '-' hh:mm a");
    
    @Override
    public ActionForward execute(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
     ActionFormVentas af = (ActionFormVentas) form;
     Integer idVenta = af.getIdVenta();
     Integer idCliente = af.getIdCliente();
     Integer idProducto = af.getIdProducto();
     Integer idUsuario = af.getIdUsuario();
     Integer idSucursal = af.getIdSucursal();
     Integer cantidad = af.getCantidad();
     Double monto = af.getMonto();
     String fechaVenta = af.getFechaVenta();
     String action = af.getAction();
     String mensaje = af.getMensaje();
     
     if (af == null || action == null){
         af.setError("<div class = 'alert alert-danger'> Esta ocurriendo un problema</div>");
         return map.findForward(errorVEN);
     }
     
     if(action.equals("Agregar")){
         String adver = "";  
         String adver5 = "";
         String adver6 = "";
   
         
         
         if(cantidad == null || cantidad.equals("") || cantidad == 0){
             adver5 = "*Ingrese la cantidad de producto deseado.";
         }
         if(monto == null || monto.equals("") || monto == 0){
             adver6 = "Ingrese el monto total.";
         }
       
         
         if (!adver.equals("")){
               ClienteMantenimiento cm = new ClienteMantenimiento(); 
            List<Clientes> listaCli=cm.consultarTodosClientes();
            af. setListaCli(listaCli);
            request.setAttribute("listaCli", listaCli);
            
            ProductosMantenimiento mprod=new ProductosMantenimiento();
            List<Productos>listaProd =mprod.consultarTodosProductos();
            af.setListaPro(listaProd);
            request.setAttribute("listaProd", listaProd);
            
            MantenimientoUsuario mu =new MantenimientoUsuario();
            List<Usuario>listaUsu =mu.consultarTodosUsuarios();
            af.setListaUsu(listaUsu);
            request.setAttribute("listaUsu", listaUsu);
            
            
            SucursalesMantenimiento scm= new SucursalesMantenimiento();
            List<Sucursales> listaSuc= scm.consultarTodosSucursales();
            af.setListaSuc(listaSuc);
            request.setAttribute("listasSuc", listaSuc);
            
             mensaje=("<div class='alert alert-danger'>Debe completar todos los requerimientos. <br>"+adver5+adver6+"</div>");
             request.setAttribute("error", mensaje);
             return map.findForward(irFormVenta);
     }
          String fechaHoy = formatoFecha.format(new Date());
          System.out.println("Fecha:"+fechaHoy);
         VentasMantenimiento ven = new VentasMantenimiento();
         System.out.println("idVenta:"+idVenta);
         System.out.println("idCliente:"+idCliente);
         System.out.println("idProducto:"+idProducto);
         System.out.println("idUsuario:"+idUsuario);
         System.out.println("idSucursal:"+idSucursal);
         System.out.println("cantidad:"+cantidad);
         System.out.println("monto: $"+monto);

         
         Double mont = monto*cantidad;
         
      int vent= ven.guardarVenta(idCliente, idProducto, idUsuario, idSucursal, cantidad, mont, fechaHoy);
      List<Ventas>listaVen=ven.consultarTodosVentas();
      af.setListaVen(listaVen);
            if (vent == 1) {
                mensaje = "La Venta ha sido registrada con Éxito";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "La Venta NO ha sido registrada con Éxito";
                request.setAttribute("error", mensaje);

            }
            return map.findForward(agregarVEN);

        }
      if (action.equals("Agregar Ventas")) {
            ClienteMantenimiento cm = new ClienteMantenimiento(); 
            List<Clientes> listaCli=cm.consultarTodosClientes();
            af. setListaCli(listaCli);
            request.setAttribute("listaCli", listaCli);
            
            ProductosMantenimiento mprod=new ProductosMantenimiento();
            List<Productos>listaProd =mprod.consultarTodosProductos();
            af.setListaPro(listaProd);
            request.setAttribute("listaProd", listaProd);
            
            MantenimientoUsuario mu =new MantenimientoUsuario();
            List<Usuario>listaUsu =mu.consultarTodosUsuarios();
            af.setListaUsu(listaUsu);
            request.setAttribute("listaUsu", listaUsu);
            
            
            SucursalesMantenimiento scm= new SucursalesMantenimiento();
            List<Sucursales> listaSuc= scm.consultarTodosSucursales();
            af.setListaSuc(listaSuc);
            request.setAttribute("listasSuc", listaSuc);
            
            return map.findForward(irFormVenta);
            }        
         

     
          if(action.equals("Consultar")){
         VentasMantenimiento ven = new VentasMantenimiento();
         List<Ventas> listaVEN = ven.consultarTodosVentas();
         System.out.println("ESTA ES SU LISTA: "+listaVEN);
         if(listaVEN==null){
             af.setError("<div class='alert alert-danger'>No hay Datos Guardados en la base de datos sobre ventas.</div>");
             return map.findForward(consultarVEN);
         }else{
             af.setListaVen(listaVEN);
             return map.findForward(consultarVEN);
         }
     }
     
     
        if (action.equals("Actualizar")) {
      VentasMantenimiento vem = new VentasMantenimiento();
      Ventas ven= vem.consultarVentas(idVenta);
      
       if (ven == null) {
                af.setError("<div class='alert alert-danger'> No se puede realizar la consulta para actualizar la venta..</div>");
                return map.findForward(errorVEN);
            } else {
           System.out.println("ID:"+ ven.getIdVenta());
           af.setIdVenta(ven.getIdVenta());
           af.setIdProducto(ven.getProductos().getIdProducto());
           af.setIdCliente(ven.getClientes().getIdCliente());
           af.setIdSucursal(ven.getSucursales().getIdSucursal());
           af.setIdUsuario(ven.getUsuario().getIdUsuario());
           af.setCantidad(ven.getCantidad());
           af.setMonto(ven.getMonto());
           af.setFechaVenta(ven.getFechaVenta());
       
             ClienteMantenimiento cm = new ClienteMantenimiento(); 
            List<Clientes> listaCli=cm.consultarTodosClientes();
            af. setListaCli(listaCli);
            request.setAttribute("listaCli", listaCli);
            
            ProductosMantenimiento mprod=new ProductosMantenimiento();
            List<Productos>listaProd =mprod.consultarTodosProductos();
            af.setListaPro(listaProd);
            request.setAttribute("listaProd", listaProd);
            
            MantenimientoUsuario mu =new MantenimientoUsuario();
            List<Usuario>listaUsu =mu.consultarTodosUsuarios();
            af.setListaUsu(listaUsu);
            request.setAttribute("listaUsu", listaUsu);
            
            
            SucursalesMantenimiento scm= new SucursalesMantenimiento();
            List<Sucursales> listaSuc= scm.consultarTodosSucursales();
            af.setListaSuc(listaSuc);
            request.setAttribute("listasSuc", listaSuc);
       
            return map.findForward(modificarVEN);
       
       }

      }
     if (action.equals("Modificar")) {
     
      VentasMantenimiento vem = new VentasMantenimiento();
         System.out.println("idVenta:"+idVenta);
         System.out.println("idCliente:"+idCliente);
         System.out.println("idProducto:"+idProducto);
         System.out.println("idUsuario:"+idUsuario);
         System.out.println("idSucursal:"+idSucursal);
         System.out.println("cantidad:"+cantidad);
         System.out.println("monto: $" + monto);
         System.out.println("Fecha:" + fechaVenta);
         int vent = vem.ActualizarVenta(idVenta,idCliente,idProducto, idUsuario,idSucursal, cantidad, monto, fechaVenta);
         List<Ventas> listaVEN = vem.consultarTodosVentas();
         af.setListaVen(listaVEN);
         return map.findForward(consultarVEN);

       
     }
     
     
     
     
     
     
     
     
     
     
         return null;
    }
}
