
package action;

import actionforms.ActionFormFacturas;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenimientos.FacturasMantenimiento;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import persistencias.Facturas;
import persistencias.Sucursales;
import persistencias.Ventas;

public class ActionFacturas extends org.apache.struts.action.Action {

    private static final String agregarFACT = "agregarFACT";
    private static final String consultarFACT = "consultarFACT";
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
        Sucursales idSucursales = af.getSucursales();
        Ventas idVentas = af.getVentas();
        String fechaVenta = af.getFechaVenta();
        String action = af.getAction();

        if (af == null || action == null) {
              af.setError("<div class='alert alert-danger'>Lamentamos el inconveniente, Inténtelo más Tarde</div>");
            return map.findForward(errorFACT);
        }
        
        if(action.equals("Consultar")){
            FacturasMantenimiento facMan = new FacturasMantenimiento();
            List<Facturas> listaFAC = facMan.consultarTodosFacturas();
            System.out.println("Lista: "+listaFAC);
            if(listaFAC == null){
                af.setError("<div class='alert alert-danger'>No hay datos guardados en la base de datos sobre Facturas</div>");
                return map.findForward(consultarFACT);
            }else{
                af.setListaFac(listaFAC);
                return map.findForward(consultarFACT);
            }
        }
        return null;
    }
}