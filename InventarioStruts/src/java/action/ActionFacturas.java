
package action;

import actionforms.ActionFormFacturas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.FacturasMantenimiento;
import mantenimientos.SucursalesMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencias.Facturas;
import persistencias.Sucursales;
import persistencias.Ventas;

public class ActionFacturas extends org.apache.struts.action.Action {

    private static final String agregarFACT = "agregarFACT";
    private static final String consultarFACT = "consultarFACT";
    private static final String todasFACT = "todasFACT";
    private static final String consultarIdFACT = "consultarIdFACT";
    private static final String modificarFACT = "modificarFACT";
    private static final String borrarFACT = "borrarFACT";
    private static final String eliminarFACT = "eliminarFACT";
    private static final String errorFACT = "errorFACT";

    @Override
    public ActionForward execute(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ActionFormFacturas af = (ActionFormFacturas) form;
        Integer idFactura = af.getIdFactura();
        String nDocumento=af.getnDocumento();
        Integer idSucursal = af.getIdSucursal();
        String fechaVenta = af.getFechaVenta();
        String estadoFactura=af.getEstadoFactura();
        String action = af.getAction();
        String mensaje = "";

        if (af == null || action == null) {
              af.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde</div>");
            return map.findForward(errorFACT);
        }
        
        if(action.equals("Consultar")){
            FacturasMantenimiento facMan = new FacturasMantenimiento();
            List<Facturas> listaFac = facMan.consultarFacturasDisponibles();
            
            if(listaFac.isEmpty()){
               mensaje="No se ha reizado ninguna  venta por eso no exite la factura";
                request.setAttribute("info", mensaje);
            
            }else{
                af.setListaFac(listaFac);
                
            }
            return map.findForward(consultarFACT);
        }
        
        if(action.equals("Cancelar")){
            FacturasMantenimiento facMan = new FacturasMantenimiento();
            List<Facturas> listaFac = facMan.consultarFacturasDisponibles();
            System.out.println("Esta la Lista de las facturas: "+listaFac);
            if(listaFac.isEmpty()){
               mensaje="No se ha reizado ninguna  venta por eso no exite la factura";
                request.setAttribute("info", mensaje);
            
            }else{
                af.setListaFac(listaFac);
                
            }
            return map.findForward(consultarFACT);
        }
        
         if (action.equals("Archivo Facturas")) {
           FacturasMantenimiento facMan = new FacturasMantenimiento();
            List<Facturas> listaFact = facMan.consultarFacturasArchivadas();
            System.out.println("Lista: "+listaFact);
            if (listaFact.isEmpty()) {
                mensaje = "No Se ha archivado ninguna Factura Aún";
                request.setAttribute("info", mensaje);
                return map.findForward(todasFACT);
            } else {
                af.setListaFact(listaFact);
                return map.findForward(todasFACT);
            }
            
        }
        
         if (action.equals("Actualizar")) {
            FacturasMantenimiento facMan = new FacturasMantenimiento();
            Facturas ft=facMan.consultarFacturaId(idFactura);
            if (ft == null) {
                mensaje = "Hay un problema en el Sistema!(action facturas)";
                request.setAttribute("error", mensaje);
                return map.findForward(errorFACT);
            } else {
                
                System.out.println("Id:"+ ft.getIdFactura());    
                af.setIdFactura(ft.getIdFactura());
                af.setnDocumento(ft.getNDocumento());
                af.setFechaVenta(ft.getFechaVenta());
                af.setIdSucursal(ft.getSucursales().getIdSucursal());
                af.setEstadoFactura(ft.getEstadoFactura());

                SucursalesMantenimiento scm = new SucursalesMantenimiento();
                List<Sucursales> listaSuc = scm.consultarTodosSucursales();
                af.setListaSuc(listaSuc);
                request.setAttribute("listasSuc", listaSuc);

                return map.findForward(modificarFACT);

            }

        }
         if (action.equals("Modificar")) {
          FacturasMantenimiento fam = new FacturasMantenimiento();
          int ftr=fam.ActualizarFacturas(idFactura, nDocumento, fechaVenta, idSucursal, estadoFactura);
          
          if(ftr == 1){
                mensaje = "La factura se ha modificado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al modificar la venta!";
                request.setAttribute("error", mensaje);
            }
         List<Facturas> listaFac =fam.consultarFacturasDisponibles();
         af.setListaFac(listaFac);
         return map.findForward(consultarFACT);
         }
        
          if (action.equals("Archivar")) {
          FacturasMantenimiento fam = new FacturasMantenimiento();
          int key= Integer.parseInt(request.getParameter("id"));
          
              System.out.println("id:"+key);
              
              Facturas arch=fam.consultarFacturaId(key);
              String nDoc=arch.getNDocumento();
              String fechaV= arch.getFechaVenta();
              int idSuc=arch.getSucursales().getIdSucursal();
              
              int r=fam.ArchivarFacturas(key, nDoc, fechaV, idSuc);
              if(r == 1){
                mensaje = "Se ha archivado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al archivar!";
                request.setAttribute("error", mensaje);
            }
               List<Facturas> listaFac =fam.consultarFacturasDisponibles();
              if (listaFac.isEmpty()) {
                mensaje = "No Se ha realizado ninguna Venta Aún";
                request.setAttribute("info", mensaje);
            } else {
                af.setListaFac(listaFac);
            }
            return map.findForward(consultarFACT); 
              
          }
          
          if (action.equals("Activar")) {
          FacturasMantenimiento fam = new FacturasMantenimiento();
          int key= Integer.parseInt(request.getParameter("id"));
          
              System.out.println("id:"+key);
              
              Facturas arch=fam.consultarFacturaId(key);
              String nDoc=arch.getNDocumento();
              String fechaV= arch.getFechaVenta();
              int idSuc=arch.getSucursales().getIdSucursal();
              
              int r=fam.ActivarFacturas(key, nDoc, fechaV, idSuc);
                     
              if(r == 1){
                mensaje = "Se ha activado con Éxito!";
                request.setAttribute("mensaje", mensaje);
            } else {
                mensaje = "Error al activar!";
                request.setAttribute("error", mensaje);
            }
               List<Facturas> listaFac =fam.consultarFacturasArchivadas();
              if (listaFac.isEmpty()) {
                mensaje = "No Se ha realizado ninguna Venta y no hay factura Aún";
                request.setAttribute("info", mensaje);
            } else {
            }
            return map.findForward(todasFACT); 
              
          }
          
           if(action.equals("Volver")){
            FacturasMantenimiento facMan = new FacturasMantenimiento();
            List<Facturas> listaFac = facMan.consultarTodosFacturas();
            System.out.println("Lista: "+listaFac);
            if(listaFac.isEmpty()){
               mensaje="No se ha reizado ninguna  venta por eso no exite la factura";
                request.setAttribute("info", mensaje);
            
            }else{
                af.setListaFac(listaFac);
                
            }
            return map.findForward(consultarFACT);
        }
        
        return null;
    }
}