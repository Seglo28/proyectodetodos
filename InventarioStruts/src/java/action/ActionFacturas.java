
package action;

import actionforms.ActionFormFacturas;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionFacturas extends org.apache.struts.action.Action{
    private static final String agregarFAC = "agregarFAC";
    private static final String consultarFAC = "consultarFAC";
    private static final String consultarIdFAC = "consultarIdFAC";
    private static final String modificarFAC = "modificarFAC";
    private static final String eliminarFAC = "eliminarFAC";
    private static final String borrarFAC = "borrarFAC";
    private static final String errorFAC = "errorFAC";
    
    @Override
    public ActionForward execute(ActionMapping map, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ActionFormFacturas af = (ActionFormFacturas)form;
        Integer idFactura = af.getIdFactura();
        Integer idSucursal = af.getIdSucursal();
        Integer idVentas = af.getIdVentas();
        String fechaVenta = af.getFechaVenta();
        String action = af.getAction();
        
        if(action.equals("Agregar")){
            String adver = "";
            String adver1 = "";
            String adver2 = "";
            String adver3 = "";
            String adver4 = "";
            
            if(idSucursal == null || idSucursal.equals("")){
                adver1 = "<b>*Carencia de sucursal.<b>";
            }
            if(idVentas == null || idVentas.equals("")){
                adver2 =  "<b>*Carencia de información de ventas.<b>";
            }
            if(fechaVenta==null||fechaVenta.equals("")){
                adver3 = "<b>"
            }
        }
        
        
        return null;
    }
}