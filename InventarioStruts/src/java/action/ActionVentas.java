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
import mantenimientos.InventarioMantenimiento;
import mantenimientos.MantenimientoUsuario;
import mantenimientos.ProductosMantenimiento;
import mantenimientos.SucursalesMantenimiento;
import mantenimientos.VentasMantenimiento;
import mantenimientos.MantenimientoUsuario;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencias.Clientes;
import persistencias.Inventario;
import persistencias.Productos;
import persistencias.Sucursales;
import persistencias.Usuario;
import persistencias.Ventas;

public class ActionVentas extends org.apache.struts.action.Action {

    private static final String agregarVEN = "agregarVEN";
    private static final String consultarVEN = "consultarVEN";
     private static final String todasVEN = "todasVEN";
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
        Integer idInventario = af.getIdInventario();
        Integer idProducto = af.getIdProducto();
        Integer idUsuario = af.getIdUsuario();
        Integer idSucursal = af.getIdSucursal();
        Integer cantidad = af.getCantidad();
        Double monto = af.getMonto();
        String nDocumento = af.getNDocumento();
        String fechaVenta = af.getFechaVenta();
        String estadoVenta = af.getEstadoVenta();
        String action = af.getAction();
        String mensaje = af.getMensaje();

        if (af == null || action == null) {
            af.setError("Esta ocurriendo un problema");           
             request.setAttribute("info", mensaje);
            return map.findForward(errorVEN);
        }

        if (action.equals("Agregar")) {
            String adver = "";
            String adver5 = "";
            String adver6 = "";
            String adver7 = "";

            if (cantidad == null || cantidad.equals("") || cantidad == 0) {
                adver5 = "- Ingrese la cantidad .";
            }
            if (monto == null || monto.equals("") || monto == 0) {
                adver6 = "- Ingrese el monto total.";
            }
            if (nDocumento == null || nDocumento.equals("")) {
                adver7 = "- Ingrese el  numero de serie del documento.";
            }
            
            System.out.println("Adver7 "+adver7);

            if (!adver7.equals("")) {
                ClienteMantenimiento cm = new ClienteMantenimiento();
                List<Clientes> listaCli = cm.consultarTodosClientes();
                af.setListaCli(listaCli);
                request.setAttribute("listaCli", listaCli);

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                af.setListaPro(listaProd);
                request.setAttribute("listaProd", listaProd);

                MantenimientoUsuario mu = new MantenimientoUsuario();
                List<Usuario> listaUsu = mu.consultarTodosUsuarios();
                af.setListaUsu(listaUsu);
                request.setAttribute("listaUsu", listaUsu);

                SucursalesMantenimiento scm = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = scm.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
                request.setAttribute("listasSuc", listaSuc);

                mensaje = "Debe completar todos los requerimientos. " + adver5 + adver6 + adver7 + "";
                request.setAttribute("error", mensaje);
                return map.findForward(errorVEN);
            }
            
            String fechaHoy = formatoFecha.format(new Date());
            System.out.println("Fecha:" + fechaHoy);
            VentasMantenimiento ven = new VentasMantenimiento();
            System.out.println("idVenta:" + idVenta);
            System.out.println("idCliente:" + idCliente);
            System.out.println("idProducto:" + idProducto);
            System.out.println("idUsuario:" + idUsuario);
            System.out.println("idSucursal:" + idSucursal);
            System.out.println("nDocumento:" + nDocumento);
            System.out.println("cantidad:" + cantidad);
            System.out.println("monto: $" + monto);
            
            Ventas val = ven.valNDoc(nDocumento);
            
            if (val!=null) {
                ClienteMantenimiento cm = new ClienteMantenimiento();
                List<Clientes> listaCli = cm.consultarTodosClientes();
                af.setListaCli(listaCli);
                request.setAttribute("listaCli", listaCli);

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                af.setListaPro(listaProd);
                request.setAttribute("listaProd", listaProd);

                MantenimientoUsuario mu = new MantenimientoUsuario();
                List<Usuario> listaUsu = mu.consultarTodosUsuarios();
                af.setListaUsu(listaUsu);
                request.setAttribute("listaUsu", listaUsu);

                SucursalesMantenimiento scm = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = scm.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
                request.setAttribute("listasSuc", listaSuc);

                mensaje = "El n° de factura de venta ya fue registrado";
                request.setAttribute("info", mensaje);
                return map.findForward(errorVEN);
                
            }
           // --- extrayendo de Inventario  ---
            InventarioMantenimiento minv = new InventarioMantenimiento();
            Inventario inv = minv.consultarInventarioProducto(idProducto, idSucursal); 
         
            if(inv == null){
                ClienteMantenimiento cm = new ClienteMantenimiento();
                List<Clientes> listaCli = cm.consultarTodosClientes();
                af.setListaCli(listaCli);
                request.setAttribute("listaCli", listaCli);

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                af.setListaPro(listaProd);
                request.setAttribute("listaProd", listaProd);

                MantenimientoUsuario mu = new MantenimientoUsuario();
                List<Usuario> listaUsu = mu.consultarTodosUsuarios();
                af.setListaUsu(listaUsu);
                request.setAttribute("listaUsu", listaUsu);

                SucursalesMantenimiento scm = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = scm.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
                request.setAttribute("listasSuc", listaSuc);
                
                mensaje = ("No Existe inventario de este producto");
                request.setAttribute("warning", mensaje);
                return map.findForward(errorVEN);
            }

            Integer idInv = inv.getIdInventario();

            Double mont = monto * cantidad;

            int vent = ven.guardarVenta(idCliente, idInv, nDocumento, idProducto, idUsuario, idSucursal, cantidad, mont, fechaHoy);
            List<Ventas> listaVen = ven.consultarTodosVentas();
            af.setListaVen(listaVen);
            if (vent == 1) {
                mensaje = "La Venta ha sido registrada con Éxito";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "La Venta NO ha sido registrada con Éxito";
                request.setAttribute("error", mensaje);

            }

            if (inv != null) {
                System.out.println("Hola Mundo");
                System.out.println("Producto: " + inv.getProductos().getIdProducto());

                Integer idProduc = inv.getProductos().getIdProducto();
                Integer cant = inv.getCant() - cantidad;
                Integer stock = inv.getStock();
                String estado = "";
                Integer idProv = inv.getProveedores().getIdProveedor();
                Integer idSuc = inv.getSucursales().getIdSucursal();
                if (cant > stock) {
                    estado = "Disponible";
                } else if (cant < stock && cant > 0 || cant == stock && cant > 0) {
                    estado = "Stock";
                } else {
                    estado = "Sin Existencias";
                }
                int r = minv.actualizarInventario(idInv, idProduc, cant, stock, estado, idProv, idSuc);
                if (r == 1) {
                    System.out.println("El Inventario ha sido modificado Exitosamente");
                } else {
                    System.out.println("El Inventario falló al modificar");
                }
            } else {
                System.out.println("No sirve");
            }

            return map.findForward(agregarVEN);

        }
        if (action.equals("Agregar Ventas")) {
            ClienteMantenimiento cm = new ClienteMantenimiento();
            List<Clientes> listaCli = cm.consultarTodosClientes();
            af.setListaCli(listaCli);
            request.setAttribute("listaCli", listaCli);

            ProductosMantenimiento mprod = new ProductosMantenimiento();
            List<Productos> listaProd = mprod.consultarTodosProductos();
            af.setListaPro(listaProd);
            request.setAttribute("listaProd", listaProd);

            MantenimientoUsuario mu = new MantenimientoUsuario();
            List<Usuario> listaUsu = mu.consultarTodosUsuarios();
            af.setListaUsu(listaUsu);
            request.setAttribute("listaUsu", listaUsu);

            SucursalesMantenimiento scm = new SucursalesMantenimiento();
            List<Sucursales> listaSuc = scm.consultarTodosSucursales();
            af.setListaSuc(listaSuc);
            request.setAttribute("listasSuc", listaSuc);

            return map.findForward(irFormVenta);
        }

        if (action.equals("Consultar")) {
            VentasMantenimiento ven = new VentasMantenimiento();
            List<Ventas> listaVEN = ven.consultarTodosVentas();
            System.out.println("ESTA ES SU LISTA: " + listaVEN);
            if (listaVEN.isEmpty()) {
                mensaje="No se ha reizado ninguna  venta en la sucursal";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaVen(listaVEN);
                
            }
            return map.findForward(consultarVEN);
        }
        
        if (action.equals("Cancelar")) {
            VentasMantenimiento ven = new VentasMantenimiento();
            List<Ventas> listaVEN = ven.consultarTodosVentas();
            System.out.println("ESTA ES SU LISTA: " + listaVEN);
            if (listaVEN.isEmpty()) {
                mensaje="No se ha reizado ninguna  venta en la sucursal";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaVen(listaVEN);
               return map.findForward(consultarVEN);   
            }
          
        }
        
          if (action.equals("Archivo Ventas")) {
            VentasMantenimiento ven = new VentasMantenimiento();
            List<Ventas>listaVEN = ven.consultarVentasArchivadas();
            
            if (listaVEN.isEmpty()) {
                mensaje = "No Se ha archivado ninguna Venta Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaVen(listaVEN);
            }
            return map.findForward(todasVEN);
        }
        
          
          

        if (action.equals("Actualizar")) {
            VentasMantenimiento vem = new VentasMantenimiento();
            Ventas ven = vem.consultarVentas(idVenta);

            if (ven == null) {
                mensaje = "Hay un problema en el Sistema!(action ventas)";
                request.setAttribute("error", mensaje);
                return map.findForward(errorVEN);
            } else {
                System.out.println("ID:" + ven.getIdVenta());
                af.setIdVenta(ven.getIdVenta());
                af.setIdProducto(ven.getProductos().getIdProducto());
                af.setIdCliente(ven.getClientes().getIdCliente());
                af.setIdSucursal(ven.getSucursales().getIdSucursal());
                af.setIdUsuario(ven.getUsuario().getIdUsuario());
                af.setCantidad(ven.getCantidad());
                af.setMonto(ven.getMonto());
                af.setFechaVenta(ven.getFechaVenta());

                ClienteMantenimiento cm = new ClienteMantenimiento();
                List<Clientes> listaCli = cm.consultarTodosClientes();
                af.setListaCli(listaCli);
                request.setAttribute("listaCli", listaCli);

                ProductosMantenimiento mprod = new ProductosMantenimiento();
                List<Productos> listaProd = mprod.consultarTodosProductos();
                af.setListaPro(listaProd);
                request.setAttribute("listaProd", listaProd);

                MantenimientoUsuario mu = new MantenimientoUsuario();
                List<Usuario> listaUsu = mu.consultarTodosUsuarios();
                af.setListaUsu(listaUsu);
                request.setAttribute("listaUsu", listaUsu);

                SucursalesMantenimiento scm = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = scm.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
                request.setAttribute("listasSuc", listaSuc);

                return map.findForward(modificarVEN);

            }

        }
        if (action.equals("Modificar")) {

            VentasMantenimiento vem = new VentasMantenimiento();
            System.out.println("idVenta:" + idVenta);
            System.out.println("idCliente:" + idCliente);
            System.out.println("idProducto:" + idProducto);
            System.out.println("idUsuario:" + idUsuario);
            System.out.println("idSucursal:" + idSucursal);
            System.out.println("cantidad:" + cantidad);
            System.out.println("monto: $" + monto);
            System.out.println("Fecha:" + fechaVenta);
            
            int vent = vem.ActualizarVenta(idVenta, idCliente, idInventario, nDocumento, idProducto, idUsuario, idSucursal, cantidad, monto, fechaVenta, estadoVenta);
            if(vent == 1){
                mensaje = "La venta se ha modificado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al modificar la venta!";
                request.setAttribute("error", mensaje);
            }
            
            List<Ventas> listaVEN = vem.consultarVentasDisponibles();
            af.setListaVen(listaVEN);
            return map.findForward(consultarVEN);
        }
        if (action.equals("Archivar")) {
            VentasMantenimiento vem = new VentasMantenimiento();
            int key = Integer.parseInt(request.getParameter("id"));
            
            System.out.println("Id: "+key);
            
            Ventas arch = vem.consultarVentas(key);
            System.out.println("Cons: "+arch);
            String nD = arch.getNDocumento();
            int idCli=arch.getClientes().getIdCliente();
            int idPro = arch.getProductos().getIdProducto();
            int idSuc=arch.getSucursales().getIdSucursal();
            int idUs=arch.getUsuario().getIdUsuario();
            int idInv = arch.getInventario().getIdInventario();
            int cant = arch.getCantidad();
            double mont = arch.getMonto();
            String fechaVen = arch.getFechaVenta();
            System.out.println("Inv: "+idInv);
            int r = vem.archivarVenta(key, idCli, idInv, nD, idPro, idUs, idSuc, cant, mont, fechaVen);
            
            if(r == 1){
                mensaje = "Se ha archivado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al archivar!";
                request.setAttribute("error", mensaje);
            }
            
            List<Ventas> listaVEN = vem.consultarVentasDisponibles();
            
            if (listaVEN.isEmpty()) {
                mensaje = "No Se ha realizado ninguna Venta Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaVen(listaVEN);
            }
            return map.findForward(consultarVEN);
        }
        
         if (action.equals("Activar")) {
            VentasMantenimiento vem = new VentasMantenimiento();
            int key = Integer.parseInt(request.getParameter("id"));
            
            Ventas arch = vem.consultarVentas(key);
            String nD = arch.getNDocumento();
            int idCli=arch.getClientes().getIdCliente();
            int idPro = arch.getProductos().getIdProducto();
            int idSuc=arch.getSucursales().getIdSucursal();
            int idUs=arch.getUsuario().getIdUsuario();
            int idInv=arch.getInventario().getIdInventario();
            int cant = arch.getCantidad();
            double mont = arch.getMonto();
            
            String fechaVen = arch.getFechaVenta();
            int r =vem.activarVenta(key, idCli, idInv, nD, idPro, idUs, idSuc, cant, mont, fechaVen);
                    
            
            if(r == 1){
                mensaje = "Se ha activado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al activar!";
                request.setAttribute("error", mensaje);
            }
            
            List<Ventas> listaVEN = vem.consultarVentasArchivadas();
            
            if (listaVEN.isEmpty()) {
                mensaje = "No Se ha activado ninguna venta Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaVen(listaVEN);
            }
            return map.findForward(todasVEN);
        }
        

        if (action.equals("Borrar")) {
            VentasMantenimiento venMan = new VentasMantenimiento();
            venMan.eliminarVentas(idVenta);
           af.setError(borrarVEN);
            List<Ventas> listaVen = venMan.consultarTodosVentas();
           af.setListaVen(listaVen);
            return map.findForward(borrarVEN);
       }

      if (action.equals("Eliminar")) {
            VentasMantenimiento ven = new VentasMantenimiento();
            Ventas ventas = ven.consultarVentas(idVenta);
            if (ventas == null) {
                 return map.findForward(errorVEN);
           } else {
               af.setIdVenta(ventas.getIdVenta());
               af.setIdCliente(ventas.getClientes().getIdCliente());
               af.setIdProducto(ventas.getProductos().getIdProducto());
               af.setIdUsuario(ventas.getUsuario().getIdUsuario());
               af.setCantidad(ventas.getCantidad());
              af.setMonto(ventas.getMonto());
              af.setFechaVenta(ventas.getFechaVenta());

               ClienteMantenimiento cliMan = new ClienteMantenimiento();
                List<Clientes> listaCli = cliMan.consultarTodosClientes();
                af.setListaCli(listaCli);
               request.setAttribute("listaCli", listaCli);

                ProductosMantenimiento proMan = new ProductosMantenimiento();
                List<Productos> listaPro = proMan.consultarTodosProductos();
                af.setListaPro(listaPro);
               request.setAttribute("listaPro", listaPro);

                MantenimientoUsuario usuMan = new MantenimientoUsuario();
               List<Usuario> listaUsu = usuMan.consultarTodosUsuarios();
                af.setListaUsu(listaUsu);
               request.setAttribute("listaUsu", listaUsu);

               SucursalesMantenimiento sucMan = new SucursalesMantenimiento();
              List<Sucursales> listaSuc = sucMan.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
               request.setAttribute("listaSuc", listaSuc);

              return map.findForward(eliminarVEN);
           }
       }

       if (action.equals("Volver")) {
           VentasMantenimiento ven = new VentasMantenimiento();
          List<Ventas> listaVEN = ven.consultarTodosVentas();
           System.out.println("ESTA ES SU LISTA: " + listaVEN);
           if (listaVEN == null) {
              af.setError("<div class='alert alert-danger'>No hay Datos Guardados en la base de datos sobre ventas.</div>");
               return map.findForward(consultarVEN);
           } else {
              af.setListaVen(listaVEN);
              return map.findForward(consultarVEN);
        }
      }
            return null;
        }
    }
